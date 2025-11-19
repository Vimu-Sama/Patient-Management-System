package com.vimarsh.billing_service.controller;

import com.vimarsh.billing_service.dto.BillingServiceRequestDTO;
import com.vimarsh.billing_service.dto.BillingServiceResponseDTO;
import com.vimarsh.billing_service.service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BillingController {

    private BillingService billingService ;

    public BillingController(BillingService billingService){
        this.billingService = billingService ;
    }

    @PutMapping
    public ResponseEntity<BillingServiceResponseDTO> CreateBillingEntry (BillingServiceRequestDTO billRequestDTO){

    }
}
