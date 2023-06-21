package com.example.gas_station.repositories;

import com.example.gas_station.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findByEmail(String email);

    @Query(nativeQuery = true,
            value = "select * from gas_station.customer where email = ?1 or firstname = ?1")
    public Optional<Customer> findByEmailOrFirstname(String email);


}
