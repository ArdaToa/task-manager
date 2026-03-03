package com.ardatoa.taskmanagerapi;

import com.ardatoa.taskmanagerapi.repository.BaseRepoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = {
                "com.ardatoa.taskmanagerapi.repository",
                "com.ardatoa.taskmanagerapi.service.auth.repository",
                "com.ardatoa.taskmanagerapi.service.task.repository"
        },
        repositoryBaseClass = BaseRepoImpl.class
)
public class TaskManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApiApplication.class, args);
    }

}
