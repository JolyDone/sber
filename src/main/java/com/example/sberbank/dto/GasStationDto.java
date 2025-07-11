package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GasStationDto {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("BrandId")
    private String brandId;

    @JsonProperty("Organization")
    private OrganizationDto organization;

    @JsonProperty("Location")
    private LocationDto location;

    @JsonProperty("TakeOffMode")
    private String takeOffMode;

    @JsonProperty("PostPay")
    private boolean postPay;

    @JsonProperty("Enable")
    private boolean enable;

    @JsonProperty("Fuels")
    private List<FuelDto> fuels;

    @JsonProperty("Columns")
    private Map<String, ColumnDto> columns;
}
