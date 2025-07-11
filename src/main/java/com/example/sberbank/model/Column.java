package com.example.sberbank.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "columns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @jakarta.persistence.Column(name = "number", nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "gas_station_id", nullable = false)
    @ToString.Exclude
    private GasStation gasStation;

    @ManyToMany
    @JoinTable(
            name = "column_fuels",
            joinColumns = @JoinColumn(name = "column_id"),
            inverseJoinColumns = @JoinColumn(name = "fuel_id")
    )
    @ToString.Exclude
    private List<Fuel> fuels = new ArrayList<>();
}


