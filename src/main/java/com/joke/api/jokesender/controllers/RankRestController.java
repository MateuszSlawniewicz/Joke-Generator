package com.joke.api.jokesender.controllers;

import com.google.gson.Gson;
import com.joke.api.jokesender.dto.RankDto;
import com.joke.api.jokesender.services.JokeService;
import com.joke.api.jokesender.services.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class RankRestController {

    private final RankService rankService;
    private final JokeService jokeService;

    public RankRestController(RankService rankService, JokeService jokeService) {
        this.rankService = rankService;
        this.jokeService = jokeService;
    }

    @PostMapping("/rank")
    public void sendRank(@RequestBody RankDto rankDto) {
        RankDto rankDtoSaved = rankService.save(rankDto);
        log.info("rank: " + rankDtoSaved.toString() + " has been send");
    }


    @GetMapping("/joke/{id}")
    public String getJoke(@PathVariable Integer id) {
        return jokeService.getJokeById(id).getValue().getJoke();
    }


    @GetMapping("/test")
    public String test() {

        RankDto rankDto = new RankDto();
        rankDto.setValue(2);
        rankDto.setJokeId(201);
        Gson gson = new Gson();
        String json = gson.toJson(rankDto);
        rankService.save(rankDto);
        return json;



    }


}
