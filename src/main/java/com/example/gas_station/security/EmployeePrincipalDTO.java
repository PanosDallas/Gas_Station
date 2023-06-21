package com.example.gas_station.security;


import com.example.gas_station.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
        import java.util.List;

public class EmployeePrincipalDTO implements UserDetails {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private List<CustomGrantedAuthorityDTO> authorities;


    public EmployeePrincipalDTO(Employee employee) {
        this.email = employee.getEmail();
        this.password = employee.getPassword();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.authorities = List.of(new CustomGrantedAuthorityDTO("ROLE_EMPLOYEE"));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}