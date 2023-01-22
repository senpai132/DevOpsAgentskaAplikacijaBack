package com.DevOps2022.agentapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.User;
import com.DevOps2022.agentapplication.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
