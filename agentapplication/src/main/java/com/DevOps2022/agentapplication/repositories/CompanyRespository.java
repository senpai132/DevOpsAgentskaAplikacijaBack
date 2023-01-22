package com.DevOps2022.agentapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DevOps2022.agentapplication.model.Company;

public interface CompanyRespository extends JpaRepository<Company, Integer>{
    Company findByName(String companyName);
    List<Company> findByStatus(Boolean status);
    List<Company> findByOwnerAndStatus(String owner, Boolean status);
    List<Company> findByOwnerNotAndStatus(String owner, Boolean status);
}
