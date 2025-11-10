package com.vimarsh.patient_service.repository;

import com.vimarsh.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

}
