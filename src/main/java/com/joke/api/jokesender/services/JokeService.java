package com.joke.api.jokesender.services;

import com.joke.api.jokesender.dto.JokeDto;
import com.joke.api.jokesender.repositories.JokeRepository;
import org.springframework.stereotype.Service;

import static com.joke.api.jokesender.mappers.JokeMapper.*;

@Service
public class JokeService {
    private final JokeRepository jokeRepository;

    public JokeService(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }


    public JokeDto save(JokeDto jokeDto) {
        return INSTANCE.jokeModelToJokeDto(jokeRepository.save(INSTANCE.jokeDtoToJokeModel(jokeDto)));
    }
}
