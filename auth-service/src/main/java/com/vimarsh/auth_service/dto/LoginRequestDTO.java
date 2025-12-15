package com.vimarsh.auth_service.dto;


public class LoginRequestDTO {
    String userEmail ;
    String password;
    String role ;

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
