package com.vimarsh.auth_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank
    private String userName ;

    @NotBlank
    @Email
    private String userEmail ;

    public @NotBlank String getUserName() {
        return userName;
    }

    public @NotBlank @Email String getUserEmail() {
        return userEmail;
    }
}
