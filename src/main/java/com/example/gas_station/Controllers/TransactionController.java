package com.example.gas_station.Controllers;

import com.example.gas_station.model.Transaction;
import com.example.gas_station.repositories.TransactionRepository;
import com.example.gas_station.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionService transactionService,TransactionRepository transactionRepository){
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("")
    public List<Transaction> getAllTransactions() {

        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return transactionService.getTransactionById(id);
    }
    @PostMapping("")
    public Transaction createTransaction(@RequestBody Transaction transaction) throws Exception {

        //code that gets user by id from database
        return transactionService.createNewTransaction(transaction);
    }
    @PutMapping("/{id}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable Long id) throws Exception {

        //code that gets user by id from database
        return transactionService.updateTransaction(transaction,id);
    }

    @DeleteMapping("/{id}")
    public void deleteLedger(@PathVariable Long id) throws Exception{
        transactionService.deleteTransaction(id);
    }

}
