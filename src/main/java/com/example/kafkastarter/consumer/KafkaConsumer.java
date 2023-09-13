package com.example.kafkastarter.consumer;

import com.example.kafkastarter.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Service
@Slf4j
public class KafkaConsumer {

  @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
  private void consumer(String message) {
    log.info("Following message received: {}", kv("message", message));
  }
}
