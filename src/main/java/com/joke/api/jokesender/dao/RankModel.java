package com.joke.api.jokesender.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document(collection = "ranks")
public class RankModel {
    private Integer value;
    private Integer jokeId;
    private String date;
}
