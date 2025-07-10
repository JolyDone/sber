package com.example.sberbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDto {
    @NotNull(message = "Список топлива в колонке не может быть null")
    @Size(min = 1, message = "Колонка должна содержать минимум 1 вид топлива")
    @JsonProperty("Fuels")
    private List<@NotBlank(message = "ID топлива не может быть пустым") String> fuels;
}
