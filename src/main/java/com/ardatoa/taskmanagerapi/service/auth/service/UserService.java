package com.ardatoa.taskmanagerapi.service.auth.service;

import com.ardatoa.taskmanagerapi.service.auth.dto.UserCreateDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserResponseDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserUpdateDto;
import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import com.ardatoa.taskmanagerapi.service.base.BaseService;

public interface UserService extends BaseService<User, UserResponseDto, UserCreateDto, UserUpdateDto> {
}
