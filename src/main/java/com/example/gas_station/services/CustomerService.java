package com.example.gas_station.services;

import com.example.gas_station.exceptions.RestAppException;
import com.example.gas_station.model.Customer;
import com.example.gas_station.repositories.CustomerRepository;
import com.example.gas_station.security.EmployeePrincipalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) throws Exception {

        return customerRepository.findById(id)
                .orElseThrow(() -> new RestAppException(HttpStatus.NOT_FOUND, "ERROR_CODE_USER_NOT_FOUND", "User not found"));

    }


    public Customer createNewCustomer(Customer customer) throws Exception {

        if (customer.getIdCustomer() != null) {
            throw new Exception("Id is not null. Id is decided by DB.");
        }

        Optional<Customer> customerFromDb = customerRepository.findByEmail(customer.getEmail());
        if (customerFromDb != null){
            throw new Exception("Customer with requested email already exists...");
        }

        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Customer customer, Long id) throws Exception {

        if (! customer.getIdCustomer().equals(id)) {
            throw new Exception("ids doesn't match.");
        }

        Customer customerFromDB = this.getCustomerById(id);

        customerFromDB.setFirstname(customer.getFirstname());
        customerFromDB.setLastname(customer.getLastname());
        customerFromDB.setEmail(customer.getEmail());
        customerFromDB.setPassword(customer.getPassword());
        customerFromDB.setCardNumber(customer.getCardNumber());

       return customerRepository.save(customerFromDB);
    }

    public Customer signUp(Customer customer) throws Exception {
        // validations
        // if valid email
        // if password is strong enough
        // if is valid credit card number


        return this.createNewCustomer(customer);
    }

    public void deleteCustomer(Long id) throws Exception{

        customerRepository.deleteById(id);
    }

    public Customer getUserByEmail(String email) throws Exception {
        return customerRepository.findByEmail(email).orElseThrow(() -> new RestAppException(HttpStatus.NOT_FOUND, "ERROR_CODE_USER_NOT_FOUND", "User not found"));
    }

}
