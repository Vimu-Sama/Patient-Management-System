package com.vimarsh.billing_service.grpc;

import billing.BillingServiceGrpc;
import billing.PatientInfoRequest;
import billing.PatientInfoResponse;
import billing.PatientInfoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PatientInfoGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(PatientInfoGrpcClient.class);
    private final PatientInfoServiceGrpc.PatientInfoServiceBlockingStub patientInfoBlockingStub ;

    PatientInfoGrpcClient(@Value("${patient.service.address:localhost}") String serverAddress,
                          @Value("${grpc.patient.info.server.port:9000}" )int serverPort){
        log.info("Patient Information Grpc Service is connecting to-> {}:{}", serverAddress, serverPort) ;
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext().build() ;

        patientInfoBlockingStub= PatientInfoServiceGrpc.newBlockingStub(channel) ;
    }

    public PatientInfoResponse FetchCustomerDetails(PatientInfoRequest patientInfoRequest){
        return patientInfoBlockingStub.getPatientInformation(patientInfoRequest) ;
    }
}
