package com.vimarsh.billing_service.controller;

import com.vimarsh.billing_service.dto.BillingServiceRequestDTO;
import com.vimarsh.billing_service.dto.BillingServiceResponseDTO;
import com.vimarsh.billing_service.service.BillingServiceAPI;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
@Tag(name= "Bill APIs")
public class BillingController {

    private final BillingServiceAPI billingServiceAPI;

    public BillingController(BillingServiceAPI billingServiceAPI){
        this.billingServiceAPI = billingServiceAPI;
    }

    @PostMapping("/create")
    public ResponseEntity<BillingServiceResponseDTO> CreateBillingEntry (@RequestBody BillingServiceRequestDTO billRequestDTO){

        BillingServiceResponseDTO response =  billingServiceAPI.GenerateBill(billRequestDTO) ;
        return ResponseEntity.ok().body(response);
    }
}
