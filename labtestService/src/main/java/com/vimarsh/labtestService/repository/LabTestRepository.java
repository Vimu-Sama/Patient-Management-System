package com.vimarsh.labtestService.repository;

import com.vimarsh.labtestService.model.LabTestEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LabTestRepository extends JpaRepository<LabTestEntry, UUID>{
    List<LabTestEntry> findLabTestEntriesByPatientID(UUID id) ;
}
