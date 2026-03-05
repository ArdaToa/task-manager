package com.ardatoa.taskmanagerapi.service.task.dto;

import java.time.LocalDateTime;

public record TaskResponseDto (
        Long id,
        String title,
        String description,
        String status,
        LocalDateTime dueDate,
        LocalDateTime createdDateTime,
        LocalDateTime updatedDateTime
)
{ }