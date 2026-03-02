package com.ardatoa.taskmanagerapi.service;

import com.ardatoa.taskmanagerapi.dto.TaskDTO;
import com.ardatoa.taskmanagerapi.entity.Task;
import com.ardatoa.taskmanagerapi.entity.User;
import com.ardatoa.taskmanagerapi.repository.TaskRepository;
import com.ardatoa.taskmanagerapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.stereotype.Service;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı Bulunamadı!"));

        Task taskToSave = convertToEntity(taskDTO);
        taskToSave.setUser(currentUser);
        Task savedTask = taskRepository.save(taskToSave);
        return covertToDTO(savedTask);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı Bulunamadı!"));

        List<Task> tasks = taskRepository.findByUserId(currentUser.getId());

        return tasks.stream()
                .map(this::covertToDTO)
                .toList();
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Görev Bulunamadı! ID: " + id));
        return covertToDTO(task);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDetailsDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bulunamadı"));

        existingTask.setTitle(taskDetailsDTO.getTitle());
        existingTask.setDescription(taskDetailsDTO.getDescription());
        existingTask.setStatus(taskDetailsDTO.getStatus());
        existingTask.setDueDate(taskDetailsDTO.getDueDate());

        Task updatedTask = taskRepository.save(existingTask);

        return covertToDTO(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDTO covertToDTO(Task task){
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate()
        );
    }

    private Task convertToEntity(TaskDTO taskDTO){
        return new Task(
                taskDTO.getId(),
                taskDTO.getTitle(),
                taskDTO.getDescription(),
                taskDTO.getStatus(),
                taskDTO.getDueDate(),
                null
        );
    }
}
