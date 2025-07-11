package com.example.sberbank.service;

import com.example.sberbank.client.ApiClient;
import com.example.sberbank.dto.ColumnDto;
import com.example.sberbank.dto.FuelDto;
import com.example.sberbank.dto.GasStationDto;
import com.example.sberbank.model.*;
import com.example.sberbank.repository.GasStationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GasStationService {

    private final ApiClient apiClient;
    private final GasStationRepository gasStationRepository;
    private final OrganizationService organizationService;

    @Transactional
    public void loadAndSaveGasStations() {
        int savedCount = 0;
        try {
            var stationDtos = apiClient.getGasStations();

            for (GasStationDto dto : stationDtos) {
                Organization org = organizationService.getOrCreate(dto.getOrganization());
                GasStation gasStation = gasStationRepository.findByExternalId(dto.getId())
                        .orElseGet(GasStation::new);

                gasStation.setExternalId(dto.getId());
                gasStation.setName(dto.getName());
                gasStation.setAddress(dto.getAddress());
                gasStation.setBrand(dto.getBrand());
                gasStation.setBrandId(dto.getBrandId());
                gasStation.setOrganization(org);
                gasStation.setLocation(Location.builder()
                        .lat(dto.getLocation().getLatitude())
                        .lon(dto.getLocation().getLongitude())
                        .build());
                gasStation.setTakeOffMode(dto.getTakeOffMode());
                gasStation.setPostPay(dto.isPostPay());
                gasStation.setEnable(dto.isEnable());

                gasStation.getFuels().clear();
                gasStation.getColumns().clear();

                if (dto.getFuels() != null && !dto.getFuels().isEmpty()) {
                    for (FuelDto fuelDto : dto.getFuels()) {
                        Fuel fuel = Fuel.builder()
                                .externalId(fuelDto.getId())
                                .gasStation(gasStation)
                                .price(fuelDto.getPrice())
                                .type(fuelDto.getType())
                                .typeId(fuelDto.getTypeId())
                                .brand(fuelDto.getBrand())
                                .name(fuelDto.getName())
                                .build();
                        gasStation.getFuels().add(fuel);
                    }
                } else {
                    log.warn("⚠️ Для АЗС с externalId={} список топлива пуст или null", dto.getId());
                }

                if (dto.getColumns() == null || dto.getColumns().isEmpty()) {
                    log.error("❌ Для АЗС {} нет данных о ТРК", dto.getId());
                } else {
                    for (var entry : dto.getColumns().entrySet()) {
                        String columnNumber = entry.getKey();
                        ColumnDto columnDto = entry.getValue();

                        if (columnDto.getFuels() == null || columnDto.getFuels().isEmpty()) {
                            log.error("❌ Для АЗС {} нет данных о ТРК в колонке {}", dto.getId(), columnNumber);
                            continue;
                        }

                        Column column = Column.builder()
                                .number(columnNumber)
                                .gasStation(gasStation)
                                .build();

                        for (String fuelId : columnDto.getFuels()) {
                            gasStation.getFuels().stream()
                                    .filter(f -> f.getExternalId().equals(fuelId))
                                    .findFirst()
                                    .ifPresent(column.getGasStation().getFuels()::add);
                        }

                        gasStation.getColumns().add(column);
                    }
                }

                gasStationRepository.save(gasStation);
                log.info("✅ Сохранена АЗС с внешним ID: {}", dto.getId());
                savedCount++;
            }
        } catch (Exception e) {
            log.error("❌ Ошибка при загрузке и сохранении АЗС", e);
        }
        String message = "Загрузка и сохранение АЗС завершена. Всего сохранено: " + savedCount;
        log.info(message);
        System.out.println(message);
    }
}
