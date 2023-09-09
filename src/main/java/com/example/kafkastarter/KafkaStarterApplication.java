package com.example.kafkastarter;

import com.example.kafkastarter.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStarterApplication.class, args);
	}
}
