package com.joke.api.jokesender.emailhandlers;

import com.joke.api.jokesender.services.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class EmailHandler {

    private final JokeService jokeService;
    private final JavaMailSender javaMailSender;
private static final String EMAIL_TO_SEND = "info@sdacademy.pl";

    public EmailHandler(JokeService jokeService, JavaMailSender javaMailSender) {
        this.jokeService = jokeService;
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        String yesterday = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String joke = jokeService.getJokeOfADay(yesterday).getValue().getJoke();
        msg.setTo(EMAIL_TO_SEND);
        msg.setSubject("Best Chuck Norris Joke of the day");
        msg.setText(joke);
        javaMailSender.send(msg);
        log.info("Sending joke");
    }


}
