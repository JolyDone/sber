package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelDto {
    @NotBlank(message = "ID топлива обязательно")
    @JsonProperty("Id")
    private String id;

    @DecimalMin(value = "0.01", message = "Цена топлива должна быть больше 0")
    @JsonProperty("Price")
    private double price;

    @NotBlank(message = "Тип топлива обязателен")
    @JsonProperty("Type")
    private String type;

    @Min(value = 1, message = "ID типа топлива должен быть положительным")
    @JsonProperty("TypeId")
    private int typeId;

    @NotBlank(message = "Бренд топлива обязателен")
    @JsonProperty("Brand")
    private String brand;

    @NotBlank(message = "Название топлива обязательно")
    @JsonProperty("Name")
    private String name;
}
