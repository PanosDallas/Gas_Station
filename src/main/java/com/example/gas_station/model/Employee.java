package com.example.gas_station.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "employee", schema = "gas_station")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_employee", nullable = false)
    private Long idEmployee;
    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = -1)
    private String lastName;
    @Basic
    @Column(name = "employee_type", nullable = false, length = -1)
    private String employeeType;
    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @Basic
    @Column(name = "hire_date_start", nullable = true)
    private Timestamp hireDateStart;
    @Basic
    @Column(name = "hire_date_end", nullable = true)
    private Timestamp hireDateEnd;
    @Basic
    @Column(name = "salary_per_month", nullable = true, length = -1)
    private String salaryPerMonth;

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
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

    public Timestamp getHireDateStart() {
        return hireDateStart;
    }

    public void setHireDateStart(Timestamp hireDateStart) {
        this.hireDateStart = hireDateStart;
    }

    public Timestamp getHireDateEnd() {
        return hireDateEnd;
    }

    public void setHireDateEnd(Timestamp hireDateEnd) {
        this.hireDateEnd = hireDateEnd;
    }

    public String getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(String salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (idEmployee != null ? !idEmployee.equals(employee.idEmployee) : employee.idEmployee != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (employeeType != null ? !employeeType.equals(employee.employeeType) : employee.employeeType != null)
            return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (password != null ? !password.equals(employee.password) : employee.password != null) return false;
        if (hireDateStart != null ? !hireDateStart.equals(employee.hireDateStart) : employee.hireDateStart != null)
            return false;
        if (hireDateEnd != null ? !hireDateEnd.equals(employee.hireDateEnd) : employee.hireDateEnd != null)
            return false;
        if (salaryPerMonth != null ? !salaryPerMonth.equals(employee.salaryPerMonth) : employee.salaryPerMonth != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee != null ? idEmployee.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (employeeType != null ? employeeType.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (hireDateStart != null ? hireDateStart.hashCode() : 0);
        result = 31 * result + (hireDateEnd != null ? hireDateEnd.hashCode() : 0);
        result = 31 * result + (salaryPerMonth != null ? salaryPerMonth.hashCode() : 0);
        return result;
    }
}
