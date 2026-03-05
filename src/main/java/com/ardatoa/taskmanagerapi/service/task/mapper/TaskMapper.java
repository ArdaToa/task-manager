package com.ardatoa.taskmanagerapi.service.task.mapper;

import com.ardatoa.taskmanagerapi.mapper.BaseUpdateMapper;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskCreateDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskResponseDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskUpdateDto;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseUpdateMapper<Task, TaskResponseDto, TaskCreateDto, TaskUpdateDto> {
}
