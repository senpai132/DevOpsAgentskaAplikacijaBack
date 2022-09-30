package com.DevOps2022.agentapplication.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps2022.agentapplication.model.SalaryReview;
import com.DevOps2022.agentapplication.repositories.SalaryReviewRepository;

@Service
public class SalaryService {
    @Autowired
    SalaryReviewRepository salaryReviewRepository;

    public String addSalary(SalaryReview review) {
        review.setTimestamp(new Date());

        salaryReviewRepository.save(review);

        return "Salary added successfully. ";
    }

    public String deleteSalary(Integer id) throws Exception {
        Optional<SalaryReview> review = salaryReviewRepository.findById(id);

        salaryReviewRepository.delete(review.get());

        return "Salary deleted successfully.";
    }

    public String editSalary(SalaryReview new_review, Integer id) throws Exception {
        Optional<SalaryReview> review = salaryReviewRepository.findById(id);

        review.get().setAmount(new_review.getAmount());
        review.get().setJobtitle(new_review.getJobtitle());

        salaryReviewRepository.save(review.get());

        return "Salary review edited successfully.";
    }

    public List<SalaryReview> getSalaryReviewsByCompany(String company) {
        return salaryReviewRepository.findByCompany(company);
    }
}
