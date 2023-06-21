package com.example.gas_station.repositories;

import com.example.gas_station.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(nativeQuery = true, value = "select * from gas_station.employee where email = ?1")
    Employee findByEmail(String email);



}
