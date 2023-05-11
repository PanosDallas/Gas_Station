package com.example.gas_station.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "employees", schema = "gas_station")
public class Employees {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ide", nullable = false)
    private Long ide;
    @Basic
    @Column(name = "firstname", nullable = false, length = -1)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = -1)
    private String lastname;
    @Basic
    @Column(name = "employeetype", nullable = false, length = -1)
    private String employeetype;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "hiredatestart", nullable = false)
    private Timestamp hiredatestart;
    @Basic
    @Column(name = "hiredateend", nullable = false)
    private Timestamp hiredateend;
    @Basic
    @Column(name = "salarypermonth", nullable = false, length = -1)
    private String salarypermonth;

    public Long getIde() {
        return ide;
    }

    public void setIde(Long ide) {
        this.ide = ide;
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

    public String getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(String employeetype) {
        this.employeetype = employeetype;
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

    public Timestamp getHiredatestart() {
        return hiredatestart;
    }

    public void setHiredatestart(Timestamp hiredatestart) {
        this.hiredatestart = hiredatestart;
    }

    public Timestamp getHiredateend() {
        return hiredateend;
    }

    public void setHiredateend(Timestamp hiredateend) {
        this.hiredateend = hiredateend;
    }

    public String getSalarypermonth() {
        return salarypermonth;
    }

    public void setSalarypermonth(String salarypermonth) {
        this.salarypermonth = salarypermonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (ide != null ? !ide.equals(employees.ide) : employees.ide != null) return false;
        if (firstname != null ? !firstname.equals(employees.firstname) : employees.firstname != null) return false;
        if (lastname != null ? !lastname.equals(employees.lastname) : employees.lastname != null) return false;
        if (employeetype != null ? !employeetype.equals(employees.employeetype) : employees.employeetype != null)
            return false;
        if (email != null ? !email.equals(employees.email) : employees.email != null) return false;
        if (password != null ? !password.equals(employees.password) : employees.password != null) return false;
        if (hiredatestart != null ? !hiredatestart.equals(employees.hiredatestart) : employees.hiredatestart != null)
            return false;
        if (hiredateend != null ? !hiredateend.equals(employees.hiredateend) : employees.hiredateend != null)
            return false;
        if (salarypermonth != null ? !salarypermonth.equals(employees.salarypermonth) : employees.salarypermonth != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ide != null ? ide.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (employeetype != null ? employeetype.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (hiredatestart != null ? hiredatestart.hashCode() : 0);
        result = 31 * result + (hiredateend != null ? hiredateend.hashCode() : 0);
        result = 31 * result + (salarypermonth != null ? salarypermonth.hashCode() : 0);
        return result;
    }
}
