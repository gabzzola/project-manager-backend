package com.gabzzola.projectmanager.dto.project;

import com.gabzzola.projectmanager.dto.category.CategoryResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProjectResponseDTO(
        Long id,
        String name,
        BigDecimal budget,
        CategoryResponseDTO category,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
