package com.vimarsh.patient_service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {
		System.out.println(">>> JVM DEFAULT = " + java.util.TimeZone.getDefault().getID());
		Dotenv dotenv= Dotenv.configure().directory("./").load() ;
		dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
		SpringApplication.run(PatientServiceApplication.class, args);
	}
}
