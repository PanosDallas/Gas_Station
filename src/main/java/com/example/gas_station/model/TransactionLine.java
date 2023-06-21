package com.example.gas_station.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "transaction_line", schema = "gas_station")
public class TransactionLine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transaction_line", nullable = false)
    private Long idTransactionLine;
    @Basic
    @Column(name = "quantity", nullable = false, length = -1)
    private String quantity;
    @Basic
    @Column(name = "item_price", nullable = false, length = -1)
    private String itemPrice;
    @Basic
    @Column(name = "net_value", nullable = false, length = -1)
    private String netValue;
    @Basic
    @Column(name = "discount_percent", nullable = false, length = -1)
    private String discountPercent;
    @Basic
    @Column(name = "discount_value", nullable = false, length = -1)
    private String discountValue;
    @Basic
    @Column(name = "total_value", nullable = false, length = -1)
    private String totalValue;

    @ManyToOne
    @JoinColumn(name="id_transaction", nullable=false)
    @JsonBackReference
    private Transaction transaction;

    public Long getIdTransactionLine() {
        return idTransactionLine;
    }

    public void setIdTransactionLine(Long idTransactionLine) {
        this.idTransactionLine = idTransactionLine;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getNetValue() {
        return netValue;
    }

    public void setNetValue(String netValue) {
        this.netValue = netValue;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionLine that)) return false;
        return Objects.equals(idTransactionLine, that.idTransactionLine) && Objects.equals(quantity, that.quantity) && Objects.equals(itemPrice, that.itemPrice) && Objects.equals(netValue, that.netValue) && Objects.equals(discountPercent, that.discountPercent) && Objects.equals(discountValue, that.discountValue) && Objects.equals(totalValue, that.totalValue) && Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransactionLine, quantity, itemPrice, netValue, discountPercent, discountValue, totalValue, transaction);
    }
}
