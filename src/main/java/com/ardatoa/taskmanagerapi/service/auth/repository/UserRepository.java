package com.ardatoa.taskmanagerapi.service.auth.repository;

import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
