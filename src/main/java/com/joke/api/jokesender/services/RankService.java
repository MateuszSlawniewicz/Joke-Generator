package com.joke.api.jokesender.services;

import com.joke.api.jokesender.dao.RankModel;
import com.joke.api.jokesender.dto.RankDto;
import com.joke.api.jokesender.mappers.RankMapper;
import com.joke.api.jokesender.repositories.RankRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RankService {

    private final RankRepository rankRepository;

    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public RankDto save(RankDto rankDto) {
        RankModel rankModel = RankMapper.INSTANCE.rankDtoToRankModel(rankDto);
        rankModel.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return RankMapper.INSTANCE.rankModelToRankDto(rankRepository.save(rankModel));
    }


    public List<RankDto> getRanksByJokeId(Integer jokeId) {
        return rankRepository.findByJokeId(jokeId).stream()
                .map(RankMapper.INSTANCE::rankModelToRankDto)
                .collect(Collectors.toList());


    }
}
