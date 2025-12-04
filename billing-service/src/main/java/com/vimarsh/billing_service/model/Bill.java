package com.vimarsh.billing_service.model;

import com.google.type.DateTime;
import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    @NotNull
    private UUID PatientId;

    @NotNull
    private String patientName;

    @NotNull
    private String patientEmail;

    @NotNull
    private LocalDateTime dateOfBirth ;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus ;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType ;

    @NotNull
    private UUID serviceReferenceId ;

    @NotNull
    private LocalDateTime timeOfCreation ;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod ;

    @NotNull
    private int amount ;

    public Bill(UUID patientId, String patientName, String patientEmail, LocalDateTime dateOfBirth, PaymentStatus paymentStatus, ServiceType serviceType, UUID serviceReferenceId, LocalDateTime timeOfCreation, PaymentMethod paymentMethod, int amount) {
        PatientId = patientId;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.dateOfBirth = dateOfBirth;
        this.paymentStatus = paymentStatus;
        this.serviceType = serviceType;
        this.serviceReferenceId = serviceReferenceId;
        this.timeOfCreation = timeOfCreation;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull UUID getPatientId() {
        return PatientId;
    }

    public void setPatientId(@NotNull UUID patientId) {
        PatientId = patientId;
    }

    public @NotNull String getPatientName() {
        return patientName;
    }

    public void setPatientName(@NotNull String patientName) {
        this.patientName = patientName;
    }

    public @NotNull String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(@NotNull String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public @NotNull LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(@NotNull PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public @NotNull ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(@NotNull ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public @NotNull UUID getServiceReferenceId() {
        return serviceReferenceId;
    }

    public void setServiceReferenceId(@NotNull UUID serviceReferenceId) {
        this.serviceReferenceId = serviceReferenceId;
    }

    public @NotNull LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(@NotNull LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public @NotNull PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NotNull PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public @NotNull int getAmount() {
        return amount;
    }

    public void setAmount(@NotNull int amount) {
        this.amount = amount;
    }
}
