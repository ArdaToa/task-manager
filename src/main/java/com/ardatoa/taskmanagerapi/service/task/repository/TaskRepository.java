package com.ardatoa.taskmanagerapi.service.task.repository;

import com.ardatoa.taskmanagerapi.repository.BaseRepo;
import com.ardatoa.taskmanagerapi.service.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepo<Task> {

    List<Task> findByUserId(Long userId);

}
