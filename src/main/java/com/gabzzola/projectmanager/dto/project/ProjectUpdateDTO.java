package com.gabzzola.projectmanager.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProjectUpdateDTO(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotNull(message = "O orçamento é obrigatório")
        @Positive(message = "O orçamento deve ser maior que zero")
        BigDecimal budget,

        Long categoryId
) {}
