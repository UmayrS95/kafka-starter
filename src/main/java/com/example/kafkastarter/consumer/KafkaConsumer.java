package com.example.kafkastarter.consumer;

import com.example.kafkastarter.model.Anime;
import com.example.kafkastarter.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Service
@Slf4j
public class KafkaConsumer {

  @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
  private void consumer(ConsumerRecord<String, Anime> payload) {
    log.info("key: {}", kv("key", payload.key()));
    log.info("headers: {}", kv("headers", payload.headers()));
    log.info("partition: {}", kv("partition", payload.partition()));
    log.info("anime: {}", kv("anime", payload.value().getTitle()));
    log.info("release year: {}", kv("released", payload.value().getReleaseYear()));
  }
}
