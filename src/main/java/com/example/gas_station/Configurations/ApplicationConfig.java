//package com.example.gas_station.Configurations;
//
//
//import com.example.gas_station.model.Employee;
//import com.example.gas_station.tobereplacebydb.MockDB;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApplicationConfig {
//
//
//    @Bean
//    public MockDB mockDB() {
//        Employee employee1 = new Employee();
//        employee1.setIdEmployee(1L);
//        employee1.setFirstname("Panos");
//        employee1.setLastname("Dallas");
//        employee1.setEmail("dallaspanos@gmail.com");
//        employee1.setEmployeetype("CASHIER");
//        employee1.setPassword("123456");
//
//
//        Employee employee2 = new Employee();
//        employee2.setIdEmployee(1L);
//        employee2.setFirstname("Vasilis");
//        employee2.setLastname("Doe");
//        employee2.setEmail("anyfas14@gmail.com");
//        employee2.setEmployeetype("STAFF");
//        employee2.setPassword("123456");
//
//        Employee employee3 = new Employee();
//        employee3.setIdEmployee(1L);
//        employee3.setFirstname("John");
//        employee3.setLastname("Doe");
//        employee3.setEmail("sekas.x@gmail.com");
//        employee3.setEmployeetype("MANAGER");
//        employee3.setPassword("123456");
//
//
//        MockDB mockDB = new MockDB();
//        mockDB.addEmployee(employee1);
//        mockDB.addEmployee(employee2);
//        mockDB.addEmployee(employee2);
//
//        return mockDB;
//    }
//}
//
