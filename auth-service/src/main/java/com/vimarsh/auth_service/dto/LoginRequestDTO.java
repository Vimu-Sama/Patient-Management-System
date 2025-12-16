package com.vimarsh.auth_service.dto;


public class LoginRequestDTO {
    private String userEmail ;
    private String password;
    private String role ;

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString(){
        return "email-> " + userEmail + "\npassword-> " + password + "\nrole-> "+ role ;
    }
}
