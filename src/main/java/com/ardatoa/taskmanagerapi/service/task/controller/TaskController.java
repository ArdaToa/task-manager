package com.ardatoa.taskmanagerapi.service.task.controller;

import com.ardatoa.taskmanagerapi.common.response.ApiResponse;
import com.ardatoa.taskmanagerapi.service.task.dto.TaskResponseDto;
import com.ardatoa.taskmanagerapi.service.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ApiResponse<TaskResponseDto> createTask(@Valid @RequestBody com.ardatoa.taskmanagerapi.service.task.dto.TaskCreateDto createDto){
        TaskResponseDto tasks = taskService.save(createDto);
        return ApiResponse.success(tasks, "Görev başarıyla oluşturdu.");
    }

    @GetMapping
    public ApiResponse<List<TaskResponseDto>> getAllTasks(){
        List<TaskResponseDto> tasks = taskService.findAll();
        return ApiResponse.success(tasks, "Görevler başarıyla listelendi.");
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponseDto> getTaskById(@PathVariable Long id){
        TaskResponseDto tasks = taskService.findById(id);
        return ApiResponse.success(tasks, "Görev başarıyla getirildi.");
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponseDto> updateTask(@PathVariable Long id,
                                      @Valid @RequestBody com.ardatoa.taskmanagerapi.service.task.dto.TaskUpdateDto updateDto){
        TaskResponseDto tasks = taskService.update(id, updateDto);
        return ApiResponse.success(tasks, "Görev başarıyla güncellendi.");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
        return ApiResponse.success(null, "Görev başarıyla silindi.");
    }
}