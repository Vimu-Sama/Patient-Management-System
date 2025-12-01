package com.vimarsh.patient_service.dto;

import jakarta.validation.constraints.NotBlank;

public class BillRequestDTO {
    @NotBlank
    String patientId;

    @NotBlank
    String paymentStatus;

    @NotBlank
    String serviceType ;

    @NotBlank
    String paymentMethod ;

    @NotBlank
    int amount ;

    public @NotBlank String getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotBlank String patientId) {
        this.patientId = patientId;
    }

    public @NotBlank String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(@NotBlank String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public @NotBlank String getServiceType() {
        return serviceType;
    }

    public void setServiceType(@NotBlank String serviceType) {
        this.serviceType = serviceType;
    }

    public @NotBlank String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NotBlank String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public @NotBlank int getAmount() {
        return amount;
    }

    public void setAmount(@NotBlank int amount) {
        this.amount = amount;
    }
}
