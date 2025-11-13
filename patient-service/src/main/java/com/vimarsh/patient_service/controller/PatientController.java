package com.vimarsh.patient_service.controller;

import com.vimarsh.patient_service.dto.PatientRequestDTO;
import com.vimarsh.patient_service.dto.PatientResponseDTO;
import com.vimarsh.patient_service.dto.validators.CreatePatientValidationGroup;
import com.vimarsh.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient APIs")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping
    @Operation(summary = "Get All Patients")
    public ResponseEntity<List<PatientResponseDTO>> GetAllPatients() {
        List<PatientResponseDTO> patients = patientService.GetAllPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "Get Patient By Id")
    public ResponseEntity<PatientResponseDTO> CreatePatient(@Validated({Default.class,
            CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO requestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.CreatePatient(requestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patient")
    public ResponseEntity<PatientResponseDTO> UpdatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO requestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.UpdatePatient(id, requestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Patient")
    public ResponseEntity<PatientResponseDTO> DeletePatient(@PathVariable UUID id) {
        PatientResponseDTO patientResponseDTO = patientService.DeletePatient(id);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}
