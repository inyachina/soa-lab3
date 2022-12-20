package com.soa.lab2.service;

import com.soa.lab2.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class CallingService {
    private final WebClient webClient;

    protected <T> T get(String uri, Class<T> clazz) {
        return webClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> {
                    throw new BadRequestException();
                })
                .bodyToMono(clazz)
                .block();
    }

    protected <T> T put(String uri, T object) {
        return webClient.put()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(object), object.getClass())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> {
                    throw new BadRequestException();
                })
                .bodyToMono((Class<T>) object.getClass())
                .block();
    }

}
