package com.example.gas_station.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers", schema = "gas_station")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer", nullable = false)
    private Long idCustomer;
    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    private String firstname;
    @Basic
    @Column(name = "last_name", nullable = false, length = -1)
    private String lastname;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "card_number", nullable = false, length = -1)
    private String cardNumber;



    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customers = (Customer) o;

        if (idCustomer != null ? !idCustomer.equals(customers.idCustomer) : customers.idCustomer != null) return false;
        if (firstname != null ? !firstname.equals(customers.firstname) : customers.firstname != null) return false;
        if (lastname != null ? !lastname.equals(customers.lastname) : customers.lastname != null) return false;
        if (email != null ? !email.equals(customers.email) : customers.email != null) return false;
        if (password != null ? !password.equals(customers.password) : customers.password != null) return false;
        if (cardNumber != null ? !cardNumber.equals(customers.cardNumber) : customers.cardNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCustomer != null ? idCustomer.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        return result;
    }
}
