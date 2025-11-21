package com.vimarsh.billing_service.grpc;

import billing.*;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.time.Instant;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBill(BillingRequest billGrpcRequest, StreamObserver<BillingResponse> responseObserver){
        log.info("Billing request received-> {}", billGrpcRequest.toString()) ;

        Timestamp timestamp = Timestamp.newBuilder()
                .setSeconds(Instant.now().getEpochSecond())
                .setNanos(Instant.now().getNano())
                .build();

        //trying out with dummy data
        BillingResponse response = BillingResponse.newBuilder()
                .setBillId("123")
                .setPatientId("12345")
                .setPaymentStatus(PaymentStatus.APPROVED)
                .setServiceType(ServiceType.APPOINTMENT)
                .setServiceId("12")
                .setDateTimeOfBillGeneration(timestamp)
                .setPaymentMethod(PaymentMethod.CASH)
                .setAmount(1000).build() ;

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
