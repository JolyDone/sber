package com.example.sberbank.repository;

import com.example.sberbank.model.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface GasStationRepository extends JpaRepository<GasStation, UUID> {
    Optional<GasStation> findByExternalId(String externalId);
}