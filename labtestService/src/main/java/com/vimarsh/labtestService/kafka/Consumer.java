package com.vimarsh.labtestService.kafka;

import com.vimarsh.labtestService.dto.LabTestRequestDTO;
import com.vimarsh.labtestService.service.LabTestService;
import labtestEvents.LabTestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);
    private LabTestService labTestService ;

    public Consumer(LabTestService labTestService){
        this.labTestService = labTestService ;
    }

    @KafkaListener(topics= "billing-labtest" , groupId = "labtest")
    public void consumeEvent(byte[] labtestByteEvent){
        try {
            LabTestEvent labTestEvent = LabTestEvent.parseFrom(labtestByteEvent) ;
            LabTestRequestDTO labTestRequestDTO = new LabTestRequestDTO(
                    labTestEvent.getPatientId(),
                    labTestEvent.getDoctorId(),
                    labTestEvent.getAmount()
            ) ;
            labTestService.CreateLabTestEntry(labTestRequestDTO) ;
        } catch(Exception e){
            log.error("Certain exception caught while parsing labTestEvent-> {}", String.valueOf(e));
        }
    }
}
