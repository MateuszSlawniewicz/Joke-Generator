package com.joke.api.jokesender.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "ranks")
public class RankModel {
    private Integer id;
    private Integer value;
    private Integer jokeId;
}
