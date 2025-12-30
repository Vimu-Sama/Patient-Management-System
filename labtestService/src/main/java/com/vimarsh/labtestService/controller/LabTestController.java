package com.vimarsh.labtestService.controller;

import com.vimarsh.labtestService.dto.LabTestRequestDTO;
import com.vimarsh.labtestService.dto.LabTestResponeDTO;
import com.vimarsh.labtestService.service.LabTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/labtest/")
public class LabTestController {

    private LabTestService labTestService ;

    public LabTestController(LabTestService labTestService){
        this.labTestService= labTestService ;
    }

    @PostMapping("/create")
    public LabTestResponeDTO CreateLabTest(@RequestBody LabTestRequestDTO labTestRequestDTO){
        return labTestService.CreateLabTestEntry(labTestRequestDTO);
    }

}
