package com.DevOps2022.agentapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByCompanyOrderByTimestampDesc(String company);
}
