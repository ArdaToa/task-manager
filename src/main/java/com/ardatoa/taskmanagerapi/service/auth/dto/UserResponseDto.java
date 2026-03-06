package com.ardatoa.taskmanagerapi.service.auth.dto;

import java.time.LocalDateTime;

public record UserResponseDto(
        Long id,
        String username,
        String role,
        LocalDateTime createdDateTime,
        LocalDateTime updatedDateTime
) {}