package com.vimarsh.labtestService.repository;

import com.vimarsh.labtestService.model.LabTestEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LabTestRepository extends JpaRepository<LabTestEntry, UUID>{
    LabTestEntry findLabTestEntriesByPatientID(UUID id) ;
}
