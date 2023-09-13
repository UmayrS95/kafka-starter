package com.example.kafkastarter.producer;

import com.example.kafkastarter.model.Anime;
import com.example.kafkastarter.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaProducer {
  @Autowired
  private KafkaTemplate<String, Anime> kafkaTemplate;

  public void produceMessage(Anime anime) {
    log.info("Producing message to topic: {}", kv("message", anime.getTitle()));
    kafkaTemplate.send(AppConstants.TOPIC_NAME, anime);
  }
}
