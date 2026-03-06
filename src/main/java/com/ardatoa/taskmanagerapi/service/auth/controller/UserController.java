package com.ardatoa.taskmanagerapi.service.auth.controller;

import com.ardatoa.taskmanagerapi.controller.BaseControllerImpl;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserCreateDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserResponseDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserUpdateDto;
import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import com.ardatoa.taskmanagerapi.service.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseControllerImpl<User, UserResponseDto, UserCreateDto, UserUpdateDto> {

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }
}