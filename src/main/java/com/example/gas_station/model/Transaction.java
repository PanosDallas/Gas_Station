package com.example.gas_station.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "transactions", schema = "gas_station")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transaction", nullable = false)
    private Long idTransaction;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "payment_method", nullable = false, length = -1)
    private String paymentMethod;
    @Basic
    @Column(name = "total_value", nullable = false, length = -1)
    private String totalValue;

    @Basic
    @Column(name = "id_customer", nullable = false, length = -1)
    private Long idCustomer;
    @Basic
    @Column(name = "id_employee", nullable = false, length = -1)
    private Long idEmployee;

    @OneToMany(mappedBy = "transaction")
    @JsonManagedReference
    private List<TransactionLine> transactionLines;

    public Transaction() {
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public List<TransactionLine> getTransactionLines() {
        return transactionLines;
    }

    public void setTransactionLines(List<TransactionLine> transactionLines) {
        this.transactionLines = transactionLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(idTransaction, that.idTransaction) && Objects.equals(date, that.date) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(totalValue, that.totalValue) && Objects.equals(idCustomer, that.idCustomer) && Objects.equals(idEmployee, that.idEmployee) && Objects.equals(transactionLines, that.transactionLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction, date, paymentMethod, totalValue, idCustomer, idEmployee, transactionLines);
    }
}
