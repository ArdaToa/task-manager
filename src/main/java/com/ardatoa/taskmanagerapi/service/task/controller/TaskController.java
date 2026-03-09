package com.ardatoa.taskmanagerapi.service.task.controller;

import com.ardatoa.taskmanagerapi.common.response.ApiResponse;
import com.ardatoa.taskmanagerapi.controller.BaseControllerImpl;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskCreateDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskFilter;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskResponseDto;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskUpdateDto;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;
import com.ardatoa.taskmanagerapi.service.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController extends BaseControllerImpl<Task, TaskResponseDto, TaskCreateDto, TaskUpdateDto> {

    @Autowired
    public TaskController(TaskService taskService) {
        super(taskService);
    }

    @PostMapping("/filter")
    public ApiResponse<Page<TaskResponseDto>> getTasksByFilter(@RequestBody TaskFilter filter) {

        @SuppressWarnings("unchecked")
        Page<TaskResponseDto> pagedData = baseService.findAll((org.springframework.data.jpa.domain.Specification) filter, filter.toPageable());

        return ApiResponse.success(pagedData, "Filtrelenmiş görevler başarıyla listelendi.");
    }
}