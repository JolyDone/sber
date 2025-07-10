package com.example.sberbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String inn;

    @Column(nullable = false, unique = true)
    private String kpp;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<GasStation> gasStations = new ArrayList<>();
}
