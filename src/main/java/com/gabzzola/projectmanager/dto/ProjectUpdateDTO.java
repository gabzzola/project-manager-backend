package com.gabzzola.projectmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProjectUpdateDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotNull(message = "O orçamento é obrigatório")
    @Positive(message = "O orçamento deve ser maior que zero")
    private BigDecimal budget;
}
