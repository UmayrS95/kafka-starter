package com.example.kafkastarter.producer;

import com.example.kafkastarter.model.Anime;
import com.example.kafkastarter.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@RequiredArgsConstructor
@Service
public class KafkaProducer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
  @Autowired
  private KafkaTemplate<String, Anime> kafkaTemplate;

  public void produceMessage(Anime anime) {
    LOGGER.info("Producing message to topic: {}", kv("message", anime.getTitle()));
    kafkaTemplate.send(AppConstants.TOPIC_NAME, anime);
  }
}
