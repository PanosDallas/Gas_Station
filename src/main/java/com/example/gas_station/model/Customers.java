package com.example.gas_station.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers", schema = "gas_station")
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idc", nullable = false)
    private Long idc;
    @Basic
    @Column(name = "firstname", nullable = false, length = -1)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = -1)
    private String lastname;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "cardnumber", nullable = false, length = -1)
    private String cardnumber;

    public Long getIdc() {
        return idc;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (idc != null ? !idc.equals(customers.idc) : customers.idc != null) return false;
        if (firstname != null ? !firstname.equals(customers.firstname) : customers.firstname != null) return false;
        if (lastname != null ? !lastname.equals(customers.lastname) : customers.lastname != null) return false;
        if (email != null ? !email.equals(customers.email) : customers.email != null) return false;
        if (password != null ? !password.equals(customers.password) : customers.password != null) return false;
        if (cardnumber != null ? !cardnumber.equals(customers.cardnumber) : customers.cardnumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idc != null ? idc.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cardnumber != null ? cardnumber.hashCode() : 0);
        return result;
    }
}
