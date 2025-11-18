package com.vimarsh.billing_service.model;

import com.google.type.DateTime;
import com.vimarsh.billing_service.enums.PaymentMethod;
import com.vimarsh.billing_service.enums.PaymentStatus;
import com.vimarsh.billing_service.enums.ServiceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    @NotNull
    private UUID PatientId;

    @NotNull
    private PaymentStatus paymentStatus ;

    @NotNull
    private ServiceType serviceType ;

    @NotNull
    private UUID serviceReferenceId ;

    @NotNull
    private LocalDateTime timeOfCreation ;

    @NotNull
    private PaymentMethod paymentMethod ;

    @NotNull
    private int amount ;
}
