package com.example.kafkastarter.producer;

import com.example.kafkastarter.model.Anime;
import com.example.kafkastarter.utils.AppConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static net.logstash.logback.argument.StructuredArguments.kv;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaProducer {
  @Autowired
  private KafkaTemplate<String, Anime> kafkaTemplate;

  public void produceMessage(Anime anime) {
    log.info("Producing message to topic: {}", kv("message", anime.getTitle()));
    CompletableFuture<SendResult<String, Anime>> future = kafkaTemplate.send(AppConstants.TOPIC_NAME, anime);
    future.whenComplete((result, ex) -> {
      if (ex == null) {
        log.info("Produced anime with title: " + result.getProducerRecord().value().getTitle());
      } else {
        log.error("Exception occurred while trying to produce message: " + ex.getMessage());
      }
    });
  }
}
