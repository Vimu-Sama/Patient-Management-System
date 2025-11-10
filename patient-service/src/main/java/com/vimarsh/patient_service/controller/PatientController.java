package com.vimarsh.patient_service.controller;

import com.vimarsh.patient_service.DTO.PatientResponseDTO;
import com.vimarsh.patient_service.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService ;

    public PatientController(PatientService patientService) {
        this.patientService = patientService ;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> GetAllPatients(){
        List<PatientResponseDTO> patients = patientService.GetAllPatients();
        return ResponseEntity.ok().body(patients) ;
    }
}
