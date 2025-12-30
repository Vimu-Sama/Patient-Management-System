package com.vimarsh.labtestService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Entity
public class LabTestEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @NotNull
    private UUID patientID ;
    private UUID doctorID ;
    @NotNull
    private int amount ;

    public LabTestEntry(UUID patientID, UUID doctorID, int amount) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientID() {
        return patientID;
    }

    public void setPatientID(UUID patientID) {
        this.patientID = patientID;
    }

    public UUID getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(UUID doctorID) {
        this.doctorID = doctorID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
