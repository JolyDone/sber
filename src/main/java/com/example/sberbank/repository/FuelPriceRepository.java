package com.example.sberbank.repository;

import com.example.sberbank.model.FuelPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;
import java.util.UUID;

public interface FuelPriceRepository extends JpaRepository<FuelPrice, Long> {
}
