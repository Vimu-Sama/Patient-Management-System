package com.vimarsh.auth_service.dto;

import java.util.Optional;

public class LoginResponseDTO {
    String loginToken ;

    public LoginResponseDTO(String token) {
        this.loginToken= token ;
    }

    public String getLoginToken() {
        return loginToken;
    }
}
