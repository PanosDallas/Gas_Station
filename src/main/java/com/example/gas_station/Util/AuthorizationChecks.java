package com.example.gas_station.Util;

import com.example.gas_station.exceptions.RestAppException;
import com.example.gas_station.model.Employee;
import com.example.gas_station.services.CustomerService;
import com.example.gas_station.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationChecks {



    private EmployeeService employeeService;
    private CustomerService customerService;

    public AuthorizationChecks(EmployeeService employeeService, CustomerService customerService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
    }


    public boolean isTheSameUser(Long employeeId, Authentication authentication) throws Exception {
        Employee employee = employeeService.getEmployeeFromAuthentication(authentication);
        if (employee.getIdEmployee() != employeeId) {
            throw new RestAppException(HttpStatus.FORBIDDEN, "ERROR_CODE_FORBIDDEN", "You are not allowed to access this resource");
        }
        return true;
    }
}
