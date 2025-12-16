package com.vimarsh.auth_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId ;

    @NotNull
    private String userName;

    @NotNull
    @Email(message = "Valid email required")
    @Column(unique = true)
    private String userEmail ;

    @NotNull
    private String userPassword;

    @NotNull
    private String role;

    public User() {
    }

    public User(String userName, String userEmail, String userPassword, String role) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public @NotNull String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    public @NotNull @Email(message = "Valid email required") String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(@NotNull @Email(message = "Valid email required") String userEmail) {
        this.userEmail = userEmail;
    }

    public @NotNull String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(@NotNull String userPassword) {
        this.userPassword = userPassword;
    }

    public @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotNull String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
