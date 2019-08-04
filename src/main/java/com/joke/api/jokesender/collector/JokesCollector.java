package com.joke.api.jokesender.collector;

import com.joke.api.jokesender.dto.JokeDto;
import com.joke.api.jokesender.mappers.JokeMapper;
import com.joke.api.jokesender.services.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class JokesCollector {


    RestTemplate restTemplate = new RestTemplate();
    private final JokeService jokeService;

    public JokesCollector(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @Scheduled(cron = "* * * * * *")
    public void saveJokeFromChuckApi() {
        ResponseEntity<JokeDto> dtos = restTemplate.getForEntity("http://api.icndb.com/jokes/random", JokeDto.class);
        JokeDto savedJoke = jokeService.save(dtos.getBody());
        log.info("Joke {} has been saved",savedJoke.toString());

    }

}
