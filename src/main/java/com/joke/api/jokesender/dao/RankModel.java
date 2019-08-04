package com.joke.api.jokesender.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RankModel {
    private String id;
    private Integer value;
    private Integer jokeId;
}
