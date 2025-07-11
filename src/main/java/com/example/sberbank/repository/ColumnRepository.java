package com.example.sberbank.repository;

import com.example.sberbank.model.Column;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ColumnRepository extends JpaRepository<Column, UUID> {
    Optional<Column> findByNumberAndGasStationId(String number, UUID gasStationId);
}

