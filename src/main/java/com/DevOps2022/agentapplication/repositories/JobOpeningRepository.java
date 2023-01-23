package com.DevOps2022.agentapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.JobOpening;

public interface JobOpeningRepository extends JpaRepository<JobOpening, Integer>{
    List<JobOpening> findByCompany(String company);
}
