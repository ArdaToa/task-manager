package com.ardatoa.taskmanagerapi.service.task.service;

import com.ardatoa.taskmanagerapi.security.SecurityUtil;
import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import com.ardatoa.taskmanagerapi.service.base.BaseServiceImpl;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskCreateDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskResponseDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskUpdateDto;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;
import com.ardatoa.taskmanagerapi.service.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskResponseDto, TaskCreateDto, TaskUpdateDto>
        implements TaskService {

    private final SecurityUtil securityUtil;

    public TaskServiceImpl(TaskRepository taskRepository,
                           com.ardatoa.taskmanagerapi.service.task.mapper.TaskMapper taskMapper,
                           SecurityUtil securityUtil) {
        super(taskRepository, taskMapper);
        this.securityUtil = securityUtil;
    }

    @Override
    public TaskResponseDto save(TaskCreateDto createDto) {

        Task entity = mapper.toEntity(createDto);
        User currentUser = securityUtil.getCurrentUser();
        entity.setUser(currentUser);
        Task savedEntity = repository.save(entity);

        return mapper.toResponseDto(savedEntity);
    }
}