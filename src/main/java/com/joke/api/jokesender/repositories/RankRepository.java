package com.joke.api.jokesender.repositories;

import com.joke.api.jokesender.dao.RankModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RankRepository extends MongoRepository<RankModel, String> {
    List<RankModel> findByDate(String date);
    List<RankModel> findByJokeId(Integer id);
}
