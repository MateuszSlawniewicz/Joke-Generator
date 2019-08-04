package com.joke.api.jokesender.mappers;
import com.joke.api.jokesender.dao.JokeModel;
import com.joke.api.jokesender.dto.JokeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper
public interface JokeMapper {
    JokeMapper INSTANCE = Mappers.getMapper(JokeMapper.class);
    @Mappings({
            @Mapping(source = "value.id", target = "externalId"),
            @Mapping(source = "value.joke", target = "value"),
            @Mapping(source = "value.categories", target = "categories")
    })
    JokeModel jokeDtoToJokeEntity(JokeDto joke);
    @Mappings({
            @Mapping(source = "externalId", target = "value.id"),
            @Mapping(source = "value", target = "value.joke"),
            @Mapping(source = "categories", target = "value.categories")
    })
    JokeDto jokeEntityToJokeDto(JokeModel entity);
}