package com.example.kafkastarter.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Bean
  public NewTopic createTopic(){
    return TopicBuilder.name("anime_topic")
            .partitions(2)
            .config(TopicConfig.RETENTION_MS_CONFIG, "1209600000")
            .build();
  }
}
