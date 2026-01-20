package com.vimarsh.labtestService.controller;

import com.vimarsh.labtestService.dto.LabTestRequestDTO;
import com.vimarsh.labtestService.dto.LabTestResponeDTO;
import com.vimarsh.labtestService.model.LabTestEntry;
import com.vimarsh.labtestService.service.LabTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/labtest/")
public class LabTestController {

    private LabTestService labTestService ;

    public LabTestController(LabTestService labTestService){
        this.labTestService= labTestService ;
    }

    @PostMapping("/create")
    public ResponseEntity<LabTestResponeDTO> CreateLabTest(@RequestBody LabTestRequestDTO labTestRequestDTO){
        return ResponseEntity.ok(labTestService.CreateLabTestEntry(labTestRequestDTO)) ;
    }

    @GetMapping("/all/{patientId}")
    public ResponseEntity<List<LabTestResponeDTO>> GetAllLabTestsByPatientId(@PathVariable String patientId){
        List<LabTestEntry> l= labTestService.getAllLabTestEntriesByPatientId(UUID.fromString(patientId));
        List<LabTestResponeDTO> responses = new java.util.ArrayList<>(List.of());
        for(var itr: l){
            LabTestResponeDTO response= new LabTestResponeDTO(
                    itr.getId().toString(),
                    itr.getPatientID().toString(),
                    itr.getAmount()
            ) ;
            responses.add(response) ;
        }
        return ResponseEntity.ok(responses) ;
    }

}
