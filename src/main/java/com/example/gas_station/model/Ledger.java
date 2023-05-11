package com.example.gas_station.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ledger", schema = "gas_station")
public class Ledger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idl", nullable = false)
    private Long idl;
    @Basic
    @Column(name = "year", nullable = false, length = -1)
    private String year;
    @Basic
    @Column(name = "month", nullable = false, length = -1)
    private String month;
    @Basic
    @Column(name = "income", nullable = false, length = -1)
    private String income;
    @Basic
    @Column(name = "expenses", nullable = false, length = -1)
    private String expenses;
    @Basic
    @Column(name = "total", nullable = false, length = -1)
    private String total;

    public Long getIdl() {
        return idl;
    }

    public void setIdl(Long idl) {
        this.idl = idl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ledger ledger = (Ledger) o;

        if (idl != null ? !idl.equals(ledger.idl) : ledger.idl != null) return false;
        if (year != null ? !year.equals(ledger.year) : ledger.year != null) return false;
        if (month != null ? !month.equals(ledger.month) : ledger.month != null) return false;
        if (income != null ? !income.equals(ledger.income) : ledger.income != null) return false;
        if (expenses != null ? !expenses.equals(ledger.expenses) : ledger.expenses != null) return false;
        if (total != null ? !total.equals(ledger.total) : ledger.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idl != null ? idl.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (income != null ? income.hashCode() : 0);
        result = 31 * result + (expenses != null ? expenses.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
