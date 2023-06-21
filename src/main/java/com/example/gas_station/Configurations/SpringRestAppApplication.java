package com.example.gas_station.Configurations;

import com.example.gas_station.Controllers.EmployeeController;
import com.example.gas_station.Util.AuthorizationChecks;
import com.example.gas_station.exceptions.RestAppExceptionHandler;
import com.example.gas_station.model.Employee;
import com.example.gas_station.repositories.EmployeeRepository;
import com.example.gas_station.services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {EmployeeController.class, AuthorizationChecks.class, RestAppExceptionHandler.class, EmployeeService.class, EmployeeRepository.class,WebSecurityConfig.class})
@EnableJpaRepositories(basePackageClasses = {EmployeeRepository.class})
@EntityScan(basePackageClasses = {Employee.class})
public class SpringRestAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringRestAppApplication.class, args);
    }

}
