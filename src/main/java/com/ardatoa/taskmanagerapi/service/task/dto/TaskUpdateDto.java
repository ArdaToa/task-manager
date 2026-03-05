package com.ardatoa.taskmanagerapi.service.task.dto;

import java.time.LocalDateTime;

public record TaskUpdateDto (
        String title,
        String description,
        String status,
        LocalDateTime dueDate
)
{ }