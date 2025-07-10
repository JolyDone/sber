package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    @NotNull(message = "Долгота не может быть null")
    @DecimalMin(value = "-180.0", message = "Долгота не может быть меньше -180")
    @DecimalMax(value = "180.0", message = "Долгота не может быть больше 180")
    @JsonProperty("Lon")
    private Double longitude;

    @NotNull(message = "Широта не может быть null")
    @DecimalMin(value = "-90.0", message = "Широта не может быть меньше -90")
    @DecimalMax(value = "90.0", message = "Широта не может быть больше 90")
    @JsonProperty("Lat")
    private Double latitude;

}
