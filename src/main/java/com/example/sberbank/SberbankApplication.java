package com.example.sberbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.sberbank.service.FuelPriceService;
import com.example.sberbank.service.GasStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SberbankApplication {

    private final GasStationService gasStationService;
    private final FuelPriceService fuelPriceService;

    public static void main(String[] args) {
        SpringApplication.run(SberbankApplication.class, args);
    }

    @Bean
    public ApplicationRunner runOnStartup() {
        return args -> {
            try {
                log.info("Получение и сохранение списка АЗС...");
                gasStationService.loadAndSaveGasStations();

                log.info("Получение и сохранение цен на топливо...");
                fuelPriceService.loadAndSaveFuelPrices();

                log.info("Загрузка завершена успешно!");
            } catch (Exception e) {
                log.error("Ошибка при выполнении: {}", e.getMessage(), e);
            }
        };
    }
}

