package com.example.sberbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fuels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;  // ID из внешней системы

    @ManyToOne
    @JoinColumn(name = "gas_station_id", nullable = false)
    private GasStation gasStation;

    private double price;
    private String type;

    @Column(name = "type_id")
    private int typeId;

    private String brand;
    private String name;

    @OneToMany(mappedBy = "fuel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuelPrice> prices = new ArrayList<>();
}
