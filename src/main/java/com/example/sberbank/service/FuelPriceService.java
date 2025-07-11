package com.example.sberbank.service;

import com.example.sberbank.client.ApiClient;
import com.example.sberbank.dto.FuelPriceDto;
import com.example.sberbank.model.Fuel;
import com.example.sberbank.model.FuelPrice;
import com.example.sberbank.model.GasStation;
import com.example.sberbank.repository.FuelPriceRepository;
import com.example.sberbank.repository.FuelRepository;
import com.example.sberbank.repository.GasStationRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FuelPriceService {

    private final ApiClient apiClient;
    private final FuelRepository fuelRepository;
    private final GasStationRepository gasStationRepository;
    private final FuelPriceRepository fuelPriceRepository;
    private final Validator validator;

    @Transactional
    public void loadAndSaveFuelPrices() {
        List<FuelPriceDto> fuelPriceDtos = apiClient.getFuelPrices();
        log.info("🔎 Получено {} цен на топливо", fuelPriceDtos.size());

        for (FuelPriceDto dto : fuelPriceDtos) {
            var violations = validator.validate(dto);
            if (!violations.isEmpty()) {
                log.warn("⚠️ Пропущена некорректная цена: {}", dto);
                continue;
            }

            GasStation gasStation = gasStationRepository
                    .findByExternalId(dto.getStationId())
                    .orElse(null);
            if (gasStation == null) {
                log.warn("⚠️ АЗС с ID {} не найдена, пропущено", dto.getStationId());
                continue;
            }

            Fuel fuel = fuelRepository
                    .findByExternalIdAndGasStation(dto.getProductId(), gasStation)
                    .orElse(null);
            if (fuel == null) {
                log.warn("⚠️ Топливо с ID {} не найдено на АЗС {}, пропущено", dto.getProductId(), dto.getStationId());
                continue;
            }

            FuelPrice price = FuelPrice.builder()
                    .gasStation(gasStation)
                    .fuel(fuel)
                    .price(dto.getPrice())
                    .timestamp(LocalDateTime.now())
                    .build();

            fuelPriceRepository.save(price);
            log.info("✅ Сохранена цена {} для топлива {} на АЗС {}", dto.getPrice(), fuel.getName(), gasStation.getName());
        }

        log.info("✅ Все доступные цены обработаны");
    }
}

