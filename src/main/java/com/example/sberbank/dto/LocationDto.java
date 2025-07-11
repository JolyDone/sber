package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationDto {
    @JsonProperty("Lat")
    private double latitude;

    @JsonProperty("Lon")
    private double longitude;
}
