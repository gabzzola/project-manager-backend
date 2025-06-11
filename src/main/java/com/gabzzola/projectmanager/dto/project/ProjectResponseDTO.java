package com.gabzzola.projectmanager.dto.project;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProjectResponseDTO(
        Long id,
        String name,
        BigDecimal budget,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
