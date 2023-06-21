package com.example.gas_station.services;

import com.example.gas_station.Util.SignUpDTOTransformer;
import com.example.gas_station.exceptions.RestAppException;
import com.example.gas_station.model.Employee;
import com.example.gas_station.model.dtos.SignupEmployeeDTO;
import com.example.gas_station.repositories.EmployeeRepository;
import com.example.gas_station.security.EmployeePrincipalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService implements UserDetailsService {
    private EmployeeRepository employeeRepository;
    private SignUpDTOTransformer signUpDTOTransformer;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, SignUpDTOTransformer signUpDTOTransformer) {
        this.employeeRepository = employeeRepository;
        this.signUpDTOTransformer = signUpDTOTransformer;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) throws Exception {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not found"));
    }

    public Employee createNewEmployee(Employee employee) throws Exception {

        if (employee.getIdEmployee() != null) {
            throw new Exception("Id is not null. Id is decided by DB.");
        }

        Employee employeeFromDb = employeeRepository.findByEmail(employee.getEmail());
        if (employeeFromDb != null) {
            throw new Exception("Employee with requested email already exists...");
        }

        return employeeRepository.save(employee);
    }


    public Employee signUpEmployee(SignupEmployeeDTO employee) throws Exception {
        if (!employee.getPassword().equals(employee.getConfirmPassword())) {
            throw new RestAppException(HttpStatus.BAD_REQUEST, "ERROR_CODE_PASSWORD_MISMATCH", "Passwords do not match");
        }

        Employee newEmployee = SignUpDTOTransformer.toEntity(employee);
        newEmployee.setEmployeeType("EMPLOYEE_TYPE");
        return this.createNewEmployee(newEmployee);
    }


    public Employee updateEmployee(Employee employee, Long id) throws Exception {

        if (!employee.getIdEmployee().equals(id)) {
            throw new Exception("ids doesn't match.");
        }

        Employee employeeFromDB = this.getEmployeeById(id);

        employeeFromDB.setFirstName(employee.getFirstName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeFromDB.setEmployeeType(employee.getEmployeeType());
        employeeFromDB.setHireDateStart(employee.getHireDateStart());
        employeeFromDB.setHireDateEnd(employee.getHireDateEnd());
        employeeFromDB.setEmail(employee.getEmail());
        employeeFromDB.setPassword(employee.getPassword());
        employeeFromDB.setSalaryPerMonth(employee.getSalaryPerMonth());

        return employeeRepository.save(employeeFromDB);
    }


    public void deleteEmployee(Long id) throws Exception {

        employeeRepository.deleteById(id);
    }

    private Employee getEmployeeByEmail(String email) throws Exception {
        return employeeRepository.findByEmail(email);
//                .orElseThrow(() -> new RestAppException(HttpStatus.NOT_FOUND, "ERROR_CODE_USER_NOT_FOUND", "User not found"));
    }

    public Employee getEmployeeFromAuthentication(Authentication authentication) throws Exception {
        String email = (String) ((Jwt) ((JwtAuthenticationToken) authentication).getPrincipal()).getClaims().get("username");
        return getEmployeeByEmail(email);
    }


    public UserDetails loadEmployeeByEmployeeName(String email) throws UsernameNotFoundException {
        Employee employeeToBeLoggedIn = null;
        try {
            employeeToBeLoggedIn = this.getEmployeeByEmail(email);
        } catch (Exception e) {
            throw new UsernameNotFoundException("EMPLOYEE_NOT_FOUND", e);
        }


        return new EmployeePrincipalDTO(employeeToBeLoggedIn);
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadEmployeeByEmployeeName(username);
    }


}
