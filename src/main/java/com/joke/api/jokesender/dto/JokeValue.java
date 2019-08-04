package com.joke.api.jokesender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JokeValue {
   private Integer id;
   private String joke;
   private String[] categories;
}
