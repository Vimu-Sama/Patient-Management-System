package com.vimarsh.billing_service.model;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class LabTestEntry {
    @NotNull
    UUID patientId ;
    UUID doctorId ;
    @NotNull
    int amount ;

    public LabTestEntry() {
    }

    public LabTestEntry(UUID patientId, UUID doctorId, int amount) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.amount = amount;
    }

    public @NotNull UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public @NotNull int getAmount() {
        return amount;
    }

    public void setAmount(@NotNull int amount) {
        this.amount = amount;
    }
}
