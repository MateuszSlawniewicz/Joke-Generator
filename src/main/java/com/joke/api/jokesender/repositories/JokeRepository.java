package com.joke.api.jokesender.repositories;

import com.joke.api.jokesender.dao.JokeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JokeRepository extends MongoRepository<JokeModel, String> {
    List<JokeModel> findByExternalId(Integer id);

}
