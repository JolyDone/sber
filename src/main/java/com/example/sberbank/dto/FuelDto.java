package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FuelDto {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("Price")
    private double price;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("TypeId")
    private int typeId;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("Name")
    private String name;
}
