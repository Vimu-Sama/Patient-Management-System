package com.vimarsh.patient_service.grpc;


import billing.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;


@Service
public class BillingServiceGrpcClient {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub billingStub ;

    BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String serverAddress,
            @Value("$billing,service.grpc.port:9001") int serverPort
    ) {
        log.info("Billing service is connecting to-> {}:{}", serverAddress, serverPort) ;
        ManagedChannel channel= ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext().build() ;

        billingStub= BillingServiceGrpc.newBlockingStub(channel) ;
    }

    public BillingResponse createBill(String patientId, String paymentStatus,
                                      String serviceType, String paymentMethod,
                                      int amount){
        BillingRequest request = BillingRequest.newBuilder().setPatientId(patientId)
                .setPaymentStatus(PaymentStatus.valueOf(paymentStatus))
                .setServiceType(ServiceType.valueOf(serviceType))
                .setPaymentMethod(PaymentMethod.valueOf(paymentMethod))
                .setAmount(amount)
                .build() ;

        BillingResponse response = billingStub.createBill(request) ;
        log.info("Patient grpc client framed response-> {}", response) ;
        return response ;
    }
}
