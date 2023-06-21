package com.example.gas_station.Controllers;

import com.example.gas_station.Util.SignUpDTOTransformer;
import com.example.gas_station.model.Employee;
import com.example.gas_station.model.JwtResponseDTO;
import com.example.gas_station.model.dtos.SignupEmployeeDTO;
import com.example.gas_station.security.EmployeePrincipalDTO;
import com.example.gas_station.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private SignUpDTOTransformer signUpDTOTransformer;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public JwtResponseDTO login(Authentication authentication) {

        if (!(authentication.getPrincipal() instanceof EmployeePrincipalDTO)) {
            throw new RuntimeException("Authentication is null");
        }
        EmployeePrincipalDTO userPrincipalDTO = (EmployeePrincipalDTO) authentication.getPrincipal();
        Instant now = Instant.now();
        var claims = JwtClaimsSet.builder()
                .issuer("bootcamp-23-04")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .subject(authentication.getName())
                .claim("username", authentication.getName())
                .claim("authorities", authentication.getAuthorities())
                .claim("a", "b")
                .build();

        String jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return JwtResponseDTO
                .builder()
                .token(jwt)
                .build();
    }

    @PostMapping("/signup")
    public Employee signup(@RequestBody SignupEmployeeDTO employee) throws Exception {

        return employeeService.signUpEmployee(employee);

    }

}

