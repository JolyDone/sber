package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelPriceDto {
    @NotBlank(message = "ID АЗС обязательно")
    @JsonProperty("StationId")
    private String stationId;

    @NotBlank(message = "ID продукта обязательно")
    @JsonProperty("ProductId")
    private String productId;

    @DecimalMin(value = "0.01", message = "Цена должна быть больше 0")
    @JsonProperty("Price")
    private double price;
}