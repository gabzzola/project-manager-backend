package com.gabzzola.projectmanager.dto.category;

import java.time.LocalDateTime;

public record CategoryResponseDTO(
        Long id,
        String name,
        String textColor,
        String backgroundColor,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
