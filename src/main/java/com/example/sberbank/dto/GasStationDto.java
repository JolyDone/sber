package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GasStationDto {
    @NotBlank(message = "ID АЗС обязательно")
    @JsonProperty("Id")
    private String id;

    @NotBlank(message = "Название АЗС обязательно")
    @Size(max = 255, message = "Название слишком длинное")
    @JsonProperty("Name")
    private String name;

    @NotBlank(message = "Адрес обязателен")
    @JsonProperty("Address")
    private String address;

    @NotBlank(message = "Бренд обязателен")
    @JsonProperty("Brand")
    private String brand;

    @NotBlank(message = "ID бренда обязательно")
    @JsonProperty("BrandId")
    private String brandId;

    @NotNull(message = "Данные организации обязательны")
    @Valid
    @JsonProperty("Organization")
    private OrganizationDto organization;

    @NotNull(message = "Координаты обязательны")
    @Valid
    @JsonProperty("Location")
    private LocationDto location;

    @NotBlank(message = "Режим выдачи топлива обязателен")
    @Pattern(regexp = "both|prepay|postpay", message = "Недопустимый режим выдачи")
    @JsonProperty("TakeOffMode")
    private String takeOffMode;

    @JsonProperty("PostPay")
    private boolean postPay;

    @JsonProperty("Enable")
    private boolean enable;

    @NotNull(message = "Список топлива не может быть null")
    @Size(min = 1, message = "АЗС должна иметь минимум 1 вид топлива")
    @Valid
    @JsonProperty("Fuels")
    private List<FuelDto> fuels;

    @NotNull(message = "Данные о колонках обязательны")
    @Valid
    @JsonProperty("Columns")
    private Map<@NotBlank String, @Valid ColumnDto> columns;
}
