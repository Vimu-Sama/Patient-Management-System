package com.vimarsh.auth_service.service;


import com.vimarsh.auth_service.dto.LoginRequestDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService ;
    private final PasswordEncoder passwordEncoder ;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder){
        this.userService = userService ;
        this.passwordEncoder = passwordEncoder ;
    }

    public Optional<String> Authenticate(LoginRequestDTO loginRequestDTO){
        Optional<String> token = userService.FindUserByEmail(loginRequestDTO.getUserEmail())
                .filter((u)-> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getUserPassword()))
                .map(jwtUtil.GenerateToken(loginRequestDTO.getUserEmail(), loginRequestDTO.getRole()));
        return token ;
    }
}
