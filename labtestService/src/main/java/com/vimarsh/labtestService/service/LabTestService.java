package com.vimarsh.labtestService.service;

import com.vimarsh.labtestService.dto.LabTestRequestDTO;
import com.vimarsh.labtestService.dto.LabTestResponeDTO;
import com.vimarsh.labtestService.exception.LabTestEntryNotFoundException;
import com.vimarsh.labtestService.model.LabTestEntry;
import com.vimarsh.labtestService.repository.LabTestRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LabTestService {
    LabTestRepository labTestRepository ;

    public LabTestService(LabTestRepository repository){
        this.labTestRepository= repository ;
    }

    public LabTestResponeDTO CreateLabTestEntry(LabTestRequestDTO labTestRequestDTO){

        LabTestEntry labTestEntry = new LabTestEntry(UUID.fromString(labTestRequestDTO.getPatientID()),
                UUID.fromString(labTestRequestDTO.getDoctorID()) ,
                labTestRequestDTO.getAmount()) ;
        labTestRepository.save(labTestEntry) ;
        return new LabTestResponeDTO(
                labTestEntry.getId().toString(),
                labTestEntry.getPatientID().toString(),
                labTestEntry.getAmount()
        ) ;
    }

    public void GetAllLabTestEntryByPatientId(UUID patientId){
        LabTestEntry[] labTestEntry = new LabTestEntry[]{labTestRepository.findLabTestEntriesByPatientID(patientId)};
    }

    public void DeleteLabTestEntryById(UUID labTestEntryId){
        LabTestEntry labTestEntry= labTestRepository.findById(labTestEntryId).orElseThrow(
                ()-> new LabTestEntryNotFoundException("No Lab Test entry is present with given Id")
        );
        labTestRepository.deleteById(labTestEntryId) ;
    }

}
