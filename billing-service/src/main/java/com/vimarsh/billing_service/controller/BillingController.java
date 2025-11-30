package com.vimarsh.billing_service.controller;

import com.vimarsh.billing_service.service.BillingServiceAPI;
import org.springframework.stereotype.Controller;

@Controller
public class BillingController {

    private BillingServiceAPI billingServiceAPI;

    public BillingController(BillingServiceAPI billingServiceAPI){
        this.billingServiceAPI = billingServiceAPI;
    }

//    @PutMapping
//    public ResponseEntity<BillingServiceResponseDTO> CreateBillingEntry (BillingServiceRequestDTO billRequestDTO){
//
//    }
}
