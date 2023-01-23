package com.DevOps2022.agentapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
