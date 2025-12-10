package com.vimarsh.patient_service.kafka;

import com.vimarsh.patient_service.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    KafkaTemplate<String, byte[]> kafkaTemp ;

    public Producer(KafkaTemplate<String, byte[]> kafTemp){
        this.kafkaTemp= kafTemp ;
    }

    public void SendEvent(Patient patient){
        PatientEvent patientEvent= PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setPatientName(patient.getName())
                .setPatientEmail(patient.getEmail())
                .setEventType("PATIENT CREATED")
                .build() ;

        try{
            kafkaTemp.send("patient", patientEvent.toByteArray()) ;
        } catch (Exception e) {
            log.error("Unable to send the event-> {}", patientEvent);
        }
    }
}
