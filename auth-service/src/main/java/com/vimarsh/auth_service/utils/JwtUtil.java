package com.vimarsh.auth_service.utils;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Optional;

@Component
public class JwtUtil {

    private final Key secretKey ;

    public JwtUtil(){

    }

    public Optional<String> GenerateToken(String userEmail, String userPassword){

    }
}
