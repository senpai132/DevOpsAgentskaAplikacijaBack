package com.DevOps2022.agentapplication.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps2022.agentapplication.model.InterviewReview;
import com.DevOps2022.agentapplication.repositories.InterviewReviewRepository;

@Service
public class InterviewReviewService {
    @Autowired
    InterviewReviewRepository interviewReviewRepository;

    public String addInterviewReview(InterviewReview interviewReview) {
        interviewReview.setTimestamp(new Date());
        interviewReviewRepository.save(interviewReview);

        return "Interview review added successfully.";
    }

    public String editInterviewReview(Integer id, InterviewReview interviewReview) throws Exception{
        Optional<InterviewReview> review = interviewReviewRepository.findById(id);

        if(!review.isPresent())
            throw new Exception("Interview review not found");
        
        review.get().setTimestamp(new Date());
        review.get().setHrInterview(interviewReview.getHrInterview());
        review.get().setTechnicalInterview(interviewReview.getTechnicalInterview());
        review.get().setPosition(interviewReview.getPosition());
        
        interviewReviewRepository.save(review.get());

        return "Interview review updated successfully.";
    }

    public String deleteInterviewReview(Integer id) throws Exception {
        Optional<InterviewReview> review = interviewReviewRepository.findById(id);

        if(!review.isPresent())
            throw new Exception("Interview review not found");

        interviewReviewRepository.delete(review.get());

        return "Interview review deleted successfully.";
    }

    public List<InterviewReview> getInterviewReviewsByCompany(String company) {
        List<InterviewReview> reviews = interviewReviewRepository.findByCompany(company);

        return reviews;
    }
}
