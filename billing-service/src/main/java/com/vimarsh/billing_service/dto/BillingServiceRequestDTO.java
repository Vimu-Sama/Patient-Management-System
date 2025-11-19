package com.vimarsh.billing_service.dto;

import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;

import java.util.UUID;

public class BillingServiceRequestDTO {
    private UUID patientId ;
    private PaymentStatus paymentStatus ;
    private ServiceType serviceType ;
    private PaymentMethod paymentMethod ;
    private int amount ;
}
