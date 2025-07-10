package com.example.sberbank.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pumps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pump {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "pump_number", nullable = false)
    private String pumpNumber;  // Номер колонки (1, 2, 3...)

    @ManyToOne
    @JoinColumn(name = "gas_station_id", nullable = false)
    private GasStation gasStation;

    @ManyToMany
    @JoinTable(
            name = "pump_fuels",
            joinColumns = @JoinColumn(name = "pump_id"),
            inverseJoinColumns = @JoinColumn(name = "fuel_id")
    )
    private List<Fuel> fuels = new ArrayList<>();
}
