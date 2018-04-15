package com.example.jwtspringbootrestapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtspringbootrestapis.domain.ApplicationUser;



public interface ApplicationUserRepository extends  JpaRepository<ApplicationUser, Long>{

	ApplicationUser findByUsername(String username);
}
