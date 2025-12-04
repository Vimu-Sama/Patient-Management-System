package com.vimarsh.billing_service.dto;

import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.UUID;

public class BillingServiceResponseDTO {
    private UUID billId ;
    private UUID patientId ;
    private String patientName;
    private String patientEmail;
    private LocalDateTime dateOfBirth ;
    private PaymentStatus paymentStatus ;
    private ServiceType serviceType ;
    private PaymentMethod paymentMethod ;
    private LocalDateTime billCreationTime ;
    private int amount ;

    public BillingServiceResponseDTO(UUID billId, UUID patientId, String patientName, String patientEmail, LocalDateTime dateOfBirth, PaymentStatus paymentStatus, ServiceType serviceType, PaymentMethod paymentMethod, LocalDateTime billCreationTime, int amount) {
        this.billId = billId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.dateOfBirth = dateOfBirth;
        this.paymentStatus = paymentStatus;
        this.serviceType = serviceType;
        this.paymentMethod = paymentMethod;
        this.billCreationTime = billCreationTime;
        this.amount = amount;
    }

    public UUID getBillId() {
        return billId;
    }

    public void setBillId(UUID billId) {
        this.billId = billId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getBillCreationTime() {
        return billCreationTime;
    }

    public void setBillCreationTime(LocalDateTime billCreationTime) {
        this.billCreationTime = billCreationTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
