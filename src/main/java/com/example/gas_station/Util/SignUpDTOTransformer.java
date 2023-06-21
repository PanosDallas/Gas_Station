package com.example.gas_station.Util;

import com.example.gas_station.model.Employee;
import com.example.gas_station.model.dtos.SignupEmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class SignUpDTOTransformer {

    public static Employee toEntity(SignupEmployeeDTO dto) {
        Employee entity = new Employee();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());


        return entity;
    }

    public SignupEmployeeDTO toDTO(Employee entity) {
        SignupEmployeeDTO dto = new SignupEmployeeDTO();
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());


        return dto;
    }
}
