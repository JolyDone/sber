package com.example.sberbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "fuel_prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gas_station_id", nullable = false)
    private GasStation gasStation;

    @ManyToOne
    @JoinColumn(name = "fuel_id", nullable = false)
    private Fuel fuel;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
