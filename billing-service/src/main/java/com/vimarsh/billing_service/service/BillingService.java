package com.vimarsh.billing_service.service;

import com.vimarsh.billing_service.dto.BillingServiceRequestDTO;
import com.vimarsh.billing_service.dto.BillingServiceResponseDTO;
import com.vimarsh.billing_service.model.Bill;
import com.vimarsh.billing_service.repository.BillingRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    private BillingRepository billingRepo ;

    public BillingService(BillingRepository repo){
        this.billingRepo = repo ;
    }

//    public BillingServiceResponseDTO CreateBill(BillingServiceRequestDTO){
//
//    }
}
