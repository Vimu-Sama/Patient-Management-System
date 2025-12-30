package com.vimarsh.labtestService.dto;

public class LabTestResponeDTO {
    private String entryId ;
    private String patientId;
    private int amountPaid ;

    public LabTestResponeDTO(String entryId, String patientId, int amountPaid) {
        this.entryId = entryId;
        this.patientId = patientId;
        this.amountPaid = amountPaid;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }
}
