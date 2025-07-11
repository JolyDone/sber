package com.example.sberbank.client;


import com.example.sberbank.dto.FuelPriceDto;
import com.example.sberbank.dto.GasStationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ApiClient {
    private final RestTemplate restTemplate;
    private final String gasStationsUrl = "https://aggregator.api.test.fuelup.ru/v2/station?apikey=";
    private final String fuelPricesUrl = "https://aggregator.api.test.fuelup.ru/v2/price?apikey=";
    private final String apiKey = "uwvgx6sx47bednyy7lo6ghq56jbw8wpb";

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GasStationDto> getGasStations() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<GasStationDto[]> response = restTemplate.exchange(
                gasStationsUrl + apiKey,
                HttpMethod.GET,
                entity,
                GasStationDto[].class
        );

        return Arrays.asList(response.getBody());
    }

    public List<FuelPriceDto> getFuelPrices() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<FuelPriceDto[]> response = restTemplate.exchange(
                fuelPricesUrl + apiKey,
                HttpMethod.GET,
                entity,
                FuelPriceDto[].class
        );

        return Arrays.asList(response.getBody());
    }
}

