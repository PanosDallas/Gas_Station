package com.example.gas_station.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "transaction", schema = "gas_station")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idt", nullable = false)
    private Long idt;
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
    @Column(name = "idc", nullable = false)
    private Long idc;
    @Basic
    @Column(name = "ide", nullable = false)
    private Long ide;

    public Long getIdt() {
        return idt;
    }

    public void setIdt(Long idt) {
        this.idt = idt;
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

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public Long getIde() {
        return ide;
    }

    public void setIde(Long ide) {
        this.ide = ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (idt != null ? !idt.equals(that.idt) : that.idt != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (paymentMethod != null ? !paymentMethod.equals(that.paymentMethod) : that.paymentMethod != null)
            return false;
        if (totalValue != null ? !totalValue.equals(that.totalValue) : that.totalValue != null) return false;
        if (idc != null ? !idc.equals(that.idc) : that.idc != null) return false;
        if (ide != null ? !ide.equals(that.ide) : that.ide != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idt != null ? idt.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (totalValue != null ? totalValue.hashCode() : 0);
        result = 31 * result + (idc != null ? idc.hashCode() : 0);
        result = 31 * result + (ide != null ? ide.hashCode() : 0);
        return result;
    }
}
