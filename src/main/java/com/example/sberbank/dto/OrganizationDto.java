package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    @NotBlank(message = "Название организации обязательно")
    @JsonProperty("Name")
    private String name;

    @NotBlank(message = "ИНН обязателен")
    @Pattern(regexp = "\\d{12}", message = "ИНН должен содержать 12 цифр")
    @JsonProperty("Inn")
    private String inn;

    @NotBlank(message = "КПП обязателен")
    @Pattern(regexp = "\\d{9}", message = "КПП должен содержать 9 цифр")
    @JsonProperty("Kpp")
    private String kpp;
}
