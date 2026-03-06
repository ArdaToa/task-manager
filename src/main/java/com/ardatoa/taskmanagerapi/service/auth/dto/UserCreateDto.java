package com.ardatoa.taskmanagerapi.service.auth.dto;

public record UserCreateDto(
        String username,
        String password,
        String role
) {}