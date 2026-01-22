package com.vimarsh.patient_service.grpc;

import billing.PatientInfoRequest;
import billing.PatientInfoResponse;
import billing.PatientInfoServiceGrpc;
import com.google.protobuf.Timestamp;
import com.vimarsh.patient_service.exception.PatientNotFoundException;
import com.vimarsh.patient_service.model.Patient;
import com.vimarsh.patient_service.repository.PatientRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneOffset;
import java.util.UUID;

@GrpcService
public class PatientInfoGrpc extends PatientInfoServiceGrpc.PatientInfoServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(PatientInfoGrpc.class);
    private final PatientRepository patientRepository;

    PatientInfoGrpc(PatientRepository p){
        this.patientRepository= p ;
    }

    @Override
    public void getPatientInformation(PatientInfoRequest patientInfoRequest,
                                      StreamObserver<PatientInfoResponse> responseStreamObserver){
        log.info("Request received for gRPC-> {}", patientInfoRequest.getPatientId()) ;
        UUID patientId=  UUID.fromString(patientInfoRequest.getPatientId()) ;
        Patient p= patientRepository.findById(patientId).orElseThrow(() ->
                new PatientNotFoundException("Particular ID is not present-> " + patientId)) ;
        log.info("Request received for gRPC-> {}", p) ;
        PatientInfoResponse patientInfoResponse = PatientInfoResponse.newBuilder()
                .setId(p.getId().toString())
                .setName(p.getName())
                .setEmail(p.getEmail())
                .setAddress(p.getAddress())
                .setDateOfBirth(
                        Timestamp.newBuilder()
                                .setSeconds(p.getDateOfBirth().atStartOfDay(ZoneOffset.UTC).toEpochSecond())
                                .setNanos(0)
                                .build()
                )
                .setRegistrationDate(
                        Timestamp.newBuilder()
                                .setSeconds(p.getDateOfRegistration().atStartOfDay(ZoneOffset.UTC).toEpochSecond())
                                .setNanos(0)
                                .build()
                ).build() ;
        responseStreamObserver.onNext(patientInfoResponse) ;
        responseStreamObserver.onCompleted();
    }
}
