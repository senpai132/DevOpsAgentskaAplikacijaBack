package com.DevOps2022.agentapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
}
