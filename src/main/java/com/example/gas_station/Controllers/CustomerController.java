package com.example.gas_station.Controllers;

import com.example.gas_station.model.Customer;
import com.example.gas_station.repositories.CustomerRepository;
import com.example.gas_station.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerService customerService,CustomerRepository customerRepository){
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return customerService.getCustomerById(id);
    }
    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer) throws Exception {


        //code that gets user by id from database
        return customerService.createNewCustomer(customer);
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return customerService.updateCustomer(customer,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) throws Exception{
        customerService.deleteCustomer(id);
    }

}






