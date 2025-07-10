package com.example.sberbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Column(nullable = false)
    private double lon;  // Долгота

    @Column(nullable = false)
    private double lat;  // Широта
}