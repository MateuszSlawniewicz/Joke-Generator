package com.joke.api.jokesender.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Joke with this id not found")
public class NoJokeException extends RuntimeException {



}
