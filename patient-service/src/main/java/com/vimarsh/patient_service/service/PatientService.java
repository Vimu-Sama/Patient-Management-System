package com.vimarsh.patient_service.service;

import com.vimarsh.patient_service.dto.PatientRequestDTO;
import com.vimarsh.patient_service.dto.PatientResponseDTO;
import com.vimarsh.patient_service.exception.EmailAlreadyExistsException;
import com.vimarsh.patient_service.model.Patient;
import com.vimarsh.patient_service.repository.PatientRepository;
import com.vimarsh.patient_service.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository p){
        this.patientRepository= p ;
    }

    public List<PatientResponseDTO> GetAllPatients(){
        List<Patient> patients = patientRepository.findAll() ;
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO CreatePatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException(patientRequestDTO.getEmail()) ;
        }
        Patient patient = PatientMapper.toModel(patientRequestDTO) ;
        patientRepository.save(patient);
        return PatientMapper.toDTO(patient) ;
    }

}
