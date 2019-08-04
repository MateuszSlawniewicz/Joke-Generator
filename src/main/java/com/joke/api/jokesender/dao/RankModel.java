package com.joke.api.jokesender.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RankModel {
    private Integer id;
    private Integer value;
    private Integer jokeId;
}
