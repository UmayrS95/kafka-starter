package com.example.kafkastarter.controller;

import com.example.kafkastarter.model.AnimeRecord;
import com.example.kafkastarter.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.kv;

@RestController
@RequestMapping("/api/v1/kafka")
@Slf4j
@AllArgsConstructor
public class KafkaProducerController {

  @Autowired
  private KafkaProducer kafkaProducer;

  @PostMapping("/produceMessage")
  public ResponseEntity<String> produceMessage(@RequestBody AnimeRecord anime) {
    log.info("Received message to produceMessage endpoint: {}", kv("message", anime.getTitle()));
    kafkaProducer.produceMessage(anime);
    return ResponseEntity.ok("Message successfully produced to topic");
  }
}
