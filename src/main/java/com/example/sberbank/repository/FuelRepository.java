package com.example.sberbank.repository;

import com.example.sberbank.model.Fuel;
import com.example.sberbank.model.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FuelRepository extends JpaRepository<Fuel, UUID> {
    Optional<Fuel> findByExternalIdAndGasStation(String externalId, GasStation gasStation);
}

