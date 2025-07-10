package com.example.sberbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gas_stations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GasStation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "external_id", unique = true, nullable = false)
    private String externalId;  // ID из внешней системы

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
    private String takeOffMode;  // Режим выдачи топлива

    @Column(name = "post_pay")
    private boolean postPay;     // Оплата после заправки

    private boolean enable;     // Статус активности АЗС

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fuel> fuels = new ArrayList<>();

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pump> pumps = new ArrayList<>();

    @OneToMany(mappedBy = "gasStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuelPrice> prices = new ArrayList();
}
