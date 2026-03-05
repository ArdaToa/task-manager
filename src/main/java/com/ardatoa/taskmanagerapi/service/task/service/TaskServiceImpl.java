package com.ardatoa.taskmanagerapi.service.task.service;

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

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                           com.ardatoa.taskmanagerapi.service.task.mapper.TaskMapper taskMapper) {
        super(taskRepository, taskMapper);
        this.taskRepository = taskRepository;
    }
}