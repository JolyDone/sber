package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrganizationDto {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Inn")
    private String inn;

    @JsonProperty("Kpp")
    private String kpp;
}
