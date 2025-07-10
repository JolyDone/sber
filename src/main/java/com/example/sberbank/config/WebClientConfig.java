package com.example.sberbank.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {
    @Bean
    public CloseableHttpClient httpClient() {
        return HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(20)
                .build();
    }
}
