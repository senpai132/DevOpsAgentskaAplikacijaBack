package com.DevOps2022.agentapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.SalaryReview;

public interface SalaryReviewRepository extends JpaRepository<SalaryReview, Integer>{
    List<SalaryReview> findByCompany(String company);
}
