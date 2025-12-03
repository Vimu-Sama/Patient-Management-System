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
                .setPatientId(billGrpcRequest.getPatientId())
                .setPaymentStatus(PaymentStatus.APPROVED)
                .setServiceType(billGrpcRequest.getServiceType())
                .setServiceId("001")
                .setDateTimeOfBillGeneration(timestamp)
                .setPaymentMethod(billGrpcRequest.getPaymentMethod())
                .setAmount(billGrpcRequest.getAmount()).build() ;

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
