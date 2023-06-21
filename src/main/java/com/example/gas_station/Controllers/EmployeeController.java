package com.example.gas_station.Controllers;


import com.example.gas_station.Util.AuthorizationChecks;
import com.example.gas_station.model.Employee;
import com.example.gas_station.model.dtos.EmployeeDTO;
import com.example.gas_station.repositories.EmployeeRepository;
import com.example.gas_station.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;
    private AuthorizationChecks authorizationChecks;
    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository, AuthorizationChecks authorizationChecks){
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.authorizationChecks = authorizationChecks;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id, Authentication authentication) throws Exception {
        authorizationChecks.isTheSameUser(id, authentication);

        //code that gets user by id from database
        Employee requestedEmployee = employeeService.getEmployeeById(id);
        EmployeeDTO requestedUserDTO = EmployeeDTO.builder()
                .email(requestedEmployee.getEmail())
                .firstName(requestedEmployee.getFirstName())
                .lastName(requestedEmployee.getLastName())
                .id(requestedEmployee.getIdEmployee())
                .build();
        return requestedUserDTO;
    }
    @PostMapping("")
    public Employee createsEmployee(@RequestBody Employee employee) throws Exception {


        //code that gets user by id from database
        return employeeService.createNewEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) throws Exception {

       return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws Exception{
        employeeService.deleteEmployee(id);
    }
}
