package com.DevOps2022.agentapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.InterviewReview;

public interface InterviewReviewRepository extends JpaRepository<InterviewReview, Integer>{
    List<InterviewReview> findByCompany(String company);
}
