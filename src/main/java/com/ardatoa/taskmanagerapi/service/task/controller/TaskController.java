package com.ardatoa.taskmanagerapi.service.task.controller;

import com.ardatoa.taskmanagerapi.controller.BaseControllerImpl;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskCreateDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskResponseDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskUpdateDto;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;
import com.ardatoa.taskmanagerapi.service.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController extends BaseControllerImpl<Task, TaskResponseDto, TaskCreateDto, TaskUpdateDto> {

    @Autowired
    public TaskController(TaskService taskService) {
        super(taskService);
    }
}