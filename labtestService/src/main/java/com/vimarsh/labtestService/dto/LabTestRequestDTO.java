package com.vimarsh.labtestService.dto;

import jakarta.annotation.Nonnull;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

public class LabTestRequestDTO {
    @NotNull
    private String patientID ;
    @NotNull
    private String doctorID ;
    @NotNull
    private int amount ;

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
