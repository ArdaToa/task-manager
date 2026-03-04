




package com.ardatoa.taskmanagerapi.service.task.entity;

import com.ardatoa.taskmanagerapi.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.ardatoa.taskmanagerapi.service.auth.entity.User;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder

public class Task extends BaseDomain {

    private String title;

    private String description;

    private String status;

    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
