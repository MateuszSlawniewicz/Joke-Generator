package com.joke.api.jokesender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JokeSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokeSenderApplication.class, args);
    }

}
