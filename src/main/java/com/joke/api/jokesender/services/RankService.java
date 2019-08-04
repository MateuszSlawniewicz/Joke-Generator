package com.joke.api.jokesender.services;

import com.joke.api.jokesender.dto.RankDto;
import com.joke.api.jokesender.mappers.RankMapper;
import com.joke.api.jokesender.repositories.RankRepository;
import org.springframework.stereotype.Service;

@Service
public class RankService {

    private final RankRepository rankRepository;

    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }


    public RankDto save(RankDto rankDto) {
        return RankMapper.INSTANCE.rankModelToRankDto(rankRepository.save(RankMapper.INSTANCE.rankDtoToRankModel(rankDto)));
    }
}
