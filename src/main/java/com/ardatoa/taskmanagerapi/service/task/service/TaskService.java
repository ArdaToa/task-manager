package com.ardatoa.taskmanagerapi.service.task.service;

import com.ardatoa.taskmanagerapi.service.base.BaseService;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskCreateDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskResponseDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskUpdateDto;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;

import java.util.List;

public interface TaskService extends BaseService<Task, TaskResponseDto, TaskCreateDto, TaskUpdateDto> {

}