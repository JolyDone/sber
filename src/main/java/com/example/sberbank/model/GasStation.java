package com.example.sberbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "gas_stations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "external_id", unique = true, nullable = false)
    private String externalId;

    @Column(nullable = false)
    private String name;

    private String address;
    private String brand;

    @Column(name = "brand_id")
    private String brandId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Embedded
    private Location location;

    @Column(name = "take_off_mode")
    private String takeOffMode;

    @Column(name = "post_pay")
    private boolean postPay;

    private boolean enable;

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Fuel> fuels = new ArrayList<>();

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.example.sberbank.model.Column> columns = new ArrayList<>();

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuelPrice> prices = new ArrayList<>();
}

