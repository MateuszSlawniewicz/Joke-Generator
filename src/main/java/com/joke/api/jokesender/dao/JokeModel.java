package com.joke.api.jokesender.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document(collection = "jokes")
public class JokeModel {

    private Integer externalId;
    private String value;
    private List<String> categories = new ArrayList<>();

}
