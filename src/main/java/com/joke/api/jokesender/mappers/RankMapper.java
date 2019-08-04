package com.joke.api.jokesender.mappers;

import com.joke.api.jokesender.dao.RankModel;
import com.joke.api.jokesender.dto.RankDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankMapper {
    RankMapper INSTANCE = Mappers.getMapper(RankMapper.class);
    RankDto rankModelToRankDto(RankModel rankModel);
    RankModel rankDtoToRankModel(RankDto rankDto);
}