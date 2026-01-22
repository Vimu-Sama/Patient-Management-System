package com.vimarsh.billing_service.dto;

import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class BillingServiceRequestDTO {
    @NotNull
    private String patientId ;

    @NotNull
    private PaymentStatus paymentStatus ;

    @NotNull
    private ServiceType serviceType ;

    @NotNull
    private PaymentMethod paymentMethod ;

    @NotNull
    private int amount ;

    public @NotNull String getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull String patientId) {
        this.patientId = patientId;
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
