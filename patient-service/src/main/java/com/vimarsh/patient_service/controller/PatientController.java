package com.vimarsh.patient_service.controller;

import com.vimarsh.patient_service.dto.PatientRequestDTO;
import com.vimarsh.patient_service.dto.PatientResponseDTO;
import com.vimarsh.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<PatientResponseDTO> CreatePatient(@Valid @RequestBody PatientRequestDTO requestDTO){
        PatientResponseDTO patientResponseDTO = patientService.CreatePatient(requestDTO) ;
        return ResponseEntity.ok().body(patientResponseDTO) ;
    }
}
