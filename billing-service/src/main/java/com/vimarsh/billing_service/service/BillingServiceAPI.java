package com.vimarsh.billing_service.service;

import billing.PatientInfoRequest;
import billing.PatientInfoResponse;
import billing.PatientInfoServiceGrpc;
import com.vimarsh.billing_service.dto.BillingServiceRequestDTO;
import com.vimarsh.billing_service.dto.BillingServiceResponseDTO;
import com.vimarsh.billing_service.enums.ServiceType;
import com.vimarsh.billing_service.grpc.PatientInfoGrpcClient;
import com.vimarsh.billing_service.kafka.Producer;
import com.vimarsh.billing_service.model.Bill;
import com.vimarsh.billing_service.model.LabTestEntry;
import com.vimarsh.billing_service.repository.BillingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
public class BillingServiceAPI {

    private static final Logger log = LoggerFactory.getLogger(BillingServiceAPI.class);
    private BillingRepository billingRepo ;
    private PatientInfoGrpcClient patientInfoGrpcClient ;
    private Producer kafkaProducer ;

    public BillingServiceAPI(BillingRepository repo, PatientInfoGrpcClient grpcService){
        this.billingRepo = repo ;
        this.patientInfoGrpcClient = grpcService ;
    }

    public BillingServiceResponseDTO GenerateBill(BillingServiceRequestDTO billingServiceRequestDTO){
        PatientInfoRequest patientInfoRequest = PatientInfoRequest.newBuilder().setPatientId(
                billingServiceRequestDTO.getPatientId().toString()
        ).build() ;
        PatientInfoResponse patientInfo= patientInfoGrpcClient.FetchCustomerDetails(patientInfoRequest) ;
        Bill generatedBill = new Bill(UUID.fromString(patientInfo.getId()),
                patientInfo.getName(),
                patientInfo.getEmail(),
                LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(patientInfo.getDateOfBirth().getSeconds(), patientInfo.getDateOfBirth().getNanos()),
                        ZoneOffset.UTC
                ),
                billingServiceRequestDTO.getPaymentStatus(),
                billingServiceRequestDTO.getServiceType(),
                UUID.fromString("c621183c-1b77-4402-b230-058a5c328e1b"),
                LocalDateTime.now(),
                billingServiceRequestDTO.getPaymentMethod(),
                billingServiceRequestDTO.getAmount());
        Bill savedBill =  billingRepo.save(generatedBill) ;
        BillingServiceResponseDTO responseDTO = new BillingServiceResponseDTO(
                savedBill.getId(),
                savedBill.getPatientId(),
                savedBill.getPatientName(),
                savedBill.getPatientEmail(),
                savedBill.getDateOfBirth(),
                savedBill.getPaymentStatus(),
                savedBill.getServiceType(),
                savedBill.getPaymentMethod(),
                savedBill.getTimeOfCreation(),
                savedBill.getAmount()
        );
        SendEventToService(generatedBill) ;
        log.info("Data returned-> {}", responseDTO);
        return responseDTO;
    }

    public void SendEventToService(Bill bill){
        if(bill.getServiceType() == ServiceType.LABTEST){
            LabTestEntry labTestEntry = new LabTestEntry(
                    bill.getPatientId(),
                    UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
                    bill.getAmount()
            ) ;
            kafkaProducer.SendEvent(labTestEntry);
        }
    }
}
