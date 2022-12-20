package com.soa.lab2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${main_service_url}")
    private String host;

    @Bean
    public WebClient localApiClient() {
        return WebClient.create(host);
    }

}