package com.example.gas_station.services;

import com.example.gas_station.model.Transaction;
import com.example.gas_station.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) throws Exception {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new Exception("Transaction not found"));
    }

    public Transaction createNewTransaction(Transaction transaction) throws Exception {

        if (transaction.getIdTransaction() != null) {
            throw new Exception("Id is not null. Id is decided by DB.");
        }

        return transactionRepository.save(transaction);
    }
    public Transaction updateTransaction(Transaction transaction, Long id) throws Exception {

        if (! transaction.getIdTransaction().equals(id)) {
            throw new Exception("ids doesn't match.");
        }

        Transaction transactionFromDB = this.getTransactionById(id);

        transactionFromDB.setDate(transactionFromDB.getDate());
        transactionFromDB.setPaymentMethod(transactionFromDB.getPaymentMethod());
        transactionFromDB.setTotalValue(transactionFromDB.getTotalValue());

        return transactionRepository.save(transactionFromDB);
    }


    public void  deleteTransaction(Long id) throws Exception{

        transactionRepository.deleteById(id);
    }

}
