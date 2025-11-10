package com.vimarsh.patient_service.service;

import com.vimarsh.patient_service.DTO.PatientResponseDTO;
import com.vimarsh.patient_service.model.Patient;
import com.vimarsh.patient_service.repository.PatientRepository;
import com.vimarsh.patient_service.mapper.PatientMapper;

import java.util.List;

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository p){
        this.patientRepository= p ;
    }

    public List<PatientResponseDTO> GetAllPatients(){
        List<Patient> patients = patientRepository.findAll() ;
        return patients.stream().map(PatientMapper::toDTO).toList();
    }
}
