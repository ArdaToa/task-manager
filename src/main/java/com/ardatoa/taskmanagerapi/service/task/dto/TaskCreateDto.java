package com.ardatoa.taskmanagerapi.service.task.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TaskCreateDto(
        @NotBlank(message = "Başlık Boş Olamaz!") String title,
        String description,
        @NotBlank(message = "Durum Boş Olamaz") String status,
        LocalDateTime dueDate,
        Long userId
)
{ }