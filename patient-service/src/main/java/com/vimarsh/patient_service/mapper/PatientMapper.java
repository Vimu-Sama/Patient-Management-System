package com.vimarsh.patient_service.mapper;

import com.vimarsh.patient_service.DTO.PatientResponseDTO;
import com.vimarsh.patient_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO() ;
        patientResponseDTO.setId(patient.getUid().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDob(patient.getDateOfBirth().toString());
        return patientResponseDTO;
    }
}
