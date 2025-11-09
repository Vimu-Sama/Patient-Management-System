package com.vimarsh.patient_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uid ;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    private String address;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private LocalDate dateOfRegistration;
}
