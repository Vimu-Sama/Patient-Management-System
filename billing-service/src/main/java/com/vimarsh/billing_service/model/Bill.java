package com.vimarsh.billing_service.model;

import com.google.type.DateTime;
import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private PaymentStatus paymentStatus ;

    @NotNull
    private ServiceType serviceType ;

    @NotNull
    private UUID serviceReferenceId ;

    @NotNull
    private LocalDateTime timeOfCreation ;

    @NotNull
    private PaymentMethod paymentMethod ;

    @NotNull
    private int amount ;

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
