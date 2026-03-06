package com.ardatoa.taskmanagerapi.service.auth.service;

import com.ardatoa.taskmanagerapi.service.auth.dto.UserCreateDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserResponseDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserUpdateDto;
import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import com.ardatoa.taskmanagerapi.service.auth.mapper.UserMapper;
import com.ardatoa.taskmanagerapi.service.auth.repository.UserRepository;
import com.ardatoa.taskmanagerapi.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserResponseDto, UserCreateDto, UserUpdateDto>
        implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        super(userRepository, userMapper);
        this.userRepository = userRepository;
    }
}