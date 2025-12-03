package com.vimarsh.patient_service.dto;

import com.google.type.DateTime;

import java.time.LocalDateTime;

public class BillResponseDTO {
    private String billId ;
    private String patientId;
    private String paymentStatus ;
    private String serviceType ;
    private String serviceId ;
    private LocalDateTime dateTimeOfBillGeneration ;
    private String paymentMethod ;
    private int amount;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getDateTimeOfBillGeneration() {
        return dateTimeOfBillGeneration;
    }

    public void setDateTimeOfBillGeneration(LocalDateTime dateTimeOfBillGeneration) {
        this.dateTimeOfBillGeneration = dateTimeOfBillGeneration;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
