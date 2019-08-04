package com.joke.api.jokesender.services;

import com.joke.api.jokesender.dao.JokeModel;
import com.joke.api.jokesender.dao.RankModel;
import com.joke.api.jokesender.dto.JokeDto;
import com.joke.api.jokesender.exceptions.NoJokeException;
import com.joke.api.jokesender.repositories.JokeRepository;
import com.joke.api.jokesender.repositories.RankRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.joke.api.jokesender.mappers.JokeMapper.*;
import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

@Service
public class JokeService {
    private final JokeRepository jokeRepository;
    private final RankRepository rankRepository;

    public JokeService(JokeRepository jokeRepository, RankRepository rankRepository) {
        this.jokeRepository = jokeRepository;
        this.rankRepository = rankRepository;
    }


    public JokeDto save(JokeDto jokeDto) {
        return INSTANCE.jokeModelToJokeDto(jokeRepository.save(INSTANCE.jokeDtoToJokeModel(jokeDto)));
    }


    public JokeDto getJokeById(Integer id) {
        return jokeRepository.findByExternalId(id).stream()
                .findFirst()
                .map(INSTANCE::jokeModelToJokeDto)
                .orElseThrow(NoJokeException::new);
    }


    public JokeDto getJokeOfADay(String date) {
        Map<Integer, Double> mapOfJokesId = rankRepository.findByDate(date).stream()
                .collect(groupingBy(RankModel::getJokeId, averagingInt(RankModel::getValue)));
        Double max = max(mapOfJokesId.values());
        return mapOfJokesId.keySet().stream()
                .filter(integer -> mapOfJokesId.get(integer).equals(max))
                .findFirst()
                .map(this::getJokeById)
                .orElseThrow(NoJokeException::new);

    }

}
