package com.example.sberbank.repository;

import com.example.sberbank.model.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface GasStationRepository extends JpaRepository<GasStation, Long> {

    // Для обновления существующих АЗС
    Optional<GasStation> findByExternalId(String externalId);

    // Для проверки дубликатов
    boolean existsByExternalId(String externalId);
}