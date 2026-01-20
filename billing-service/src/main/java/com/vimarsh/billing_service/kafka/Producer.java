package com.vimarsh.billing_service.kafka;

import com.vimarsh.billing_service.model.LabTestEntry;
import labtestEvents.LabTestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);
    KafkaTemplate<String, byte[]> kafkaTemplate ;

    public Producer(KafkaTemplate<String, byte[]> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate ;
    }

    public void SendEvent(LabTestEntry labTestEntry){
        LabTestEvent labTestEvent = LabTestEvent.newBuilder()
                .setPatientId(labTestEntry.getPatientId().toString())
                .setDoctorId(labTestEntry.getDoctorId().toString())
                .setAmount(labTestEntry.getAmount())
        .build() ;

        try{
            kafkaTemplate.send("billing-labtest", labTestEvent.toByteArray()) ;
        } catch (Exception e) {
            log.error("Unable to send event-> {}", labTestEvent);
        }
    }

}
