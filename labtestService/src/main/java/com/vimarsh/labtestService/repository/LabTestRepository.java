package com.vimarsh.labtestService.repository;

import com.vimarsh.labtestService.model.LabTestEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LabTestRepository extends JpaRepository<LabTestEntry, UUID>{
    LabTestEntry findLabTestEntriesByPatientID(UUID id) ;
}
