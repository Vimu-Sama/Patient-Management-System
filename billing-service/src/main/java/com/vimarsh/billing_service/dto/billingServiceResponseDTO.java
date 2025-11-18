package com.vimarsh.billing_service.dto;

import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;

import java.time.LocalDateTime;
import java.util.UUID;

public class billingServiceResponseDTO {
    private UUID billId ;
    private UUID patientId ;
    private PaymentStatus paymentStatus ;
    private ServiceType serviceType ;
    private PaymentMethod paymentMethod ;
    private LocalDateTime billCreationTime ;
    private int amount ;
}
