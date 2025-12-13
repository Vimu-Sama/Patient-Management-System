package com.vimarsh.auth_service.dto;

import java.util.UUID;

public class UserResponseDTO {
    private UUID userId ;
    private String userName ;
    private String userEmail ;

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}