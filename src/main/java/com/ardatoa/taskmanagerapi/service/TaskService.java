package com.ardatoa.taskmanagerapi.service;

import com.ardatoa.taskmanagerapi.dto.TaskDTO;
import com.ardatoa.taskmanagerapi.entity.Task;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);

    List<TaskDTO> getAllTasks();

    TaskDTO getTaskById(Long id);

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);

}
