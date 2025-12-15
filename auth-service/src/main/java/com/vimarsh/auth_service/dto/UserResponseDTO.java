package com.vimarsh.auth_service.dto;

import java.util.UUID;

public class UserResponseDTO {
    private UUID userId ;
    private String userName ;
    private String userEmail ;
    private String userRole ;

    public UserResponseDTO(UUID userId, String userName, String userEmail, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    public UserResponseDTO() {
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "User id-> "+ userId + "\n User Name-> " + userName + "\n User Email-> " + userEmail
                + "\nUserRole-> " + userRole;
    }
}