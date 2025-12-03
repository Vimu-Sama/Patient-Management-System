package com.vimarsh.patient_service.service;

import billing.BillingRequest;
import billing.BillingResponse;
import com.vimarsh.patient_service.dto.BillRequestDTO;
import com.vimarsh.patient_service.dto.BillResponseDTO;
import com.vimarsh.patient_service.dto.PatientRequestDTO;
import com.vimarsh.patient_service.dto.PatientResponseDTO;
import com.vimarsh.patient_service.exception.EmailAlreadyExistsException;
import com.vimarsh.patient_service.exception.PatientNotFoundException;
import com.vimarsh.patient_service.grpc.BillingServiceGrpcClient;
import com.vimarsh.patient_service.model.Patient;
import com.vimarsh.patient_service.repository.PatientRepository;
import com.vimarsh.patient_service.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final BillingServiceGrpcClient billingServiceGrpcClient ;
    public PatientService(PatientRepository p, BillingServiceGrpcClient b) {
        this.patientRepository = p;
        this.billingServiceGrpcClient = b;
    }

    public List<PatientResponseDTO> GetAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO GetPatientById(UUID id){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Id was not found-> "+ id)) ;
        return PatientMapper.toDTO(patient) ;
    }

    public PatientResponseDTO CreatePatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(patientRequestDTO.getEmail());
        }
        Patient patient = PatientMapper.toModel(patientRequestDTO);
        patientRepository.save(patient);
        return PatientMapper.toDTO(patient);
    }

    public PatientResponseDTO UpdatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Id was not found-> " + id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExistsException(patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }

    public BillResponseDTO createBill(BillRequestDTO billRequestDTO){
        BillingResponse billingResponse = billingServiceGrpcClient.createBill(billRequestDTO.getPatientId(),
                billRequestDTO.getPaymentStatus(),
                billRequestDTO.getServiceType(),
                billRequestDTO.getPaymentMethod(),
                billRequestDTO.getAmount());
        BillResponseDTO billDTO= new BillResponseDTO() ;
        billDTO.setBillId(billingResponse.getBillId());
        billDTO.setPatientId(billingResponse.getPatientId());
        billDTO.setPaymentStatus(billingResponse.getPaymentStatus().toString());
        billDTO.setServiceType(billingResponse.getServiceType().toString()) ;
        billDTO.setServiceId(billingResponse.getServiceId());
        var ts = billingResponse.getDateTimeOfBillGeneration();
        Instant instant = Instant.ofEpochSecond(ts.getSeconds(), ts.getNanos());
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        billDTO.setDateTimeOfBillGeneration(ldt);
        billDTO.setPaymentMethod(billingResponse.getPaymentMethod().toString());
        billDTO.setAmount(billingResponse.getAmount());
        return billDTO ;
    }

    public PatientResponseDTO DeletePatient(UUID patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new PatientNotFoundException("Particular ID is not present-> " + patientId));
        patientRepository.deleteById(patientId);
        return PatientMapper.toDTO(patient);
    }
}
