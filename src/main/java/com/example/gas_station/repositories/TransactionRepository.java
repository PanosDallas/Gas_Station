package com.example.gas_station.repositories;


import com.example.gas_station.model.Customer;
import com.example.gas_station.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

//    @Query(nativeQuery = true, value = "select * from gas_station.transaction where idt = ?1")
//    public Transaction findById(String idt);
}
