package com.example.kafkastarter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class AnimeRecord {
  @JsonProperty
  private String title;
  @JsonProperty
  private Integer seasons;
  @JsonProperty
  private Integer numberOfEpisodes;
}
