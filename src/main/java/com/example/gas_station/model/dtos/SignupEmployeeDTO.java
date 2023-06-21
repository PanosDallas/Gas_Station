package com.example.gas_station.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SignupEmployeeDTO {

    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
}