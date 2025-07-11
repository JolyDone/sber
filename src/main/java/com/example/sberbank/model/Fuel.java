package com.example.sberbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "fuels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @ManyToOne
    @JoinColumn(name = "gas_station_id", nullable = false)
    @ToString.Exclude
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
