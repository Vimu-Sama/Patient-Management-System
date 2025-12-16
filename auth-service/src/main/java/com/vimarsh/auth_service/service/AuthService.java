package com.vimarsh.auth_service.service;


import com.vimarsh.auth_service.dto.LoginRequestDTO;
import com.vimarsh.auth_service.model.User;
import com.vimarsh.auth_service.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final UserService userService ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtUtil jwtUtil;


    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userService = userService ;
        this.passwordEncoder = passwordEncoder ;
        this.jwtUtil = jwtUtil ;
    }

    public Optional<String> Authenticate(LoginRequestDTO loginRequestDTO){
        return userService.FindUserByEmail(loginRequestDTO.getUserEmail())
                .filter((u)-> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getUserPassword()))
                .map(u -> jwtUtil.GenerateToken(u.getUserEmail(), u.getRole()));
    }

    public boolean validateToken(String token) {
        try{
            jwtUtil.validateToken(token) ;
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
