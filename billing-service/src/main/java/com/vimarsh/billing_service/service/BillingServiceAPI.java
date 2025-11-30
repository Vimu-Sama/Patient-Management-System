package com.vimarsh.billing_service.service;

import com.vimarsh.billing_service.repository.BillingRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceAPI {
    private BillingRepository billingRepo ;

    public BillingServiceAPI(BillingRepository repo){
        this.billingRepo = repo ;
    }

//    public BillingServiceResponseDTO CreateBill(BillingServiceRequestDTO){
//
//    }
}
