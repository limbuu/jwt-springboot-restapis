package com.example.jwtspringbootrestapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtspringbootrestapis.domain.Task;



public interface TaskRepository extends JpaRepository<Task, Long> {
}
