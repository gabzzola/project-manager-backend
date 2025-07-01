package com.gabzzola.projectmanager.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "A cor do texto é obrigatória")
        String textColor,

        @NotBlank(message = "A cor do fundo do texto é obrigatória")
        String backgroundColor
) {}
