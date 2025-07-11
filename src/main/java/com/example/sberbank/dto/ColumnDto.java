package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ColumnDto {
    @JsonProperty("Fuels")
    private List<String> fuels;
}
