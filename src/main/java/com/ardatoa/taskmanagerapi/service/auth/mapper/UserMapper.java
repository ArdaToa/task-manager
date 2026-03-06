package com.ardatoa.taskmanagerapi.service.auth.mapper;
import com.ardatoa.taskmanagerapi.mapper.BaseUpdateMapper;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserCreateDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserResponseDto;
import com.ardatoa.taskmanagerapi.service.auth.dto.UserUpdateDto;
import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper extends BaseUpdateMapper<User, UserResponseDto, UserCreateDto, UserUpdateDto> {

}