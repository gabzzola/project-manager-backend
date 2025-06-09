package com.gabzzola.projectmanager.dto.project;

import java.math.BigDecimal;

public record ProjectResponseDTO(
        Long id,
        String name,
        BigDecimal budget
) {}
