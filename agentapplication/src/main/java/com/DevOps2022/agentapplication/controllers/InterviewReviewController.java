package com.DevOps2022.agentapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevOps2022.agentapplication.helper.dto.InterviewReviewDTO;
import com.DevOps2022.agentapplication.helper.mappers.InterviewReviewMapper;
import com.DevOps2022.agentapplication.services.InterviewReviewService;

@RestController
@CrossOrigin
@RequestMapping("/interview")
public class InterviewReviewController {
    
    @Autowired
    private InterviewReviewService interviewReviewService;

    private InterviewReviewMapper interviewReviewMapper;
    
    @PostMapping("/add")
    public ResponseEntity<String> addInterviewReview(@RequestBody InterviewReviewDTO review) {
        return new ResponseEntity<String>(interviewReviewService.addInterviewReview(interviewReviewMapper.toEntity(review)), 
            HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editInterviewReview(@PathVariable Integer id, @RequestBody InterviewReviewDTO review) { 
        try {
            return new ResponseEntity<String>(interviewReviewService.editInterviewReview(id,
                interviewReviewMapper.toEntity(review)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInterviewReview(@PathVariable Integer id) { 
        try {
            return new ResponseEntity<String>(interviewReviewService.deleteInterviewReview(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getbycompany/{company}")
    public ResponseEntity<List<InterviewReviewDTO>> getByCompany(@PathVariable String company) {
        return new ResponseEntity<List<InterviewReviewDTO>>(interviewReviewMapper.toDtoList(interviewReviewService.getInterviewReviewsByCompany(company)), 
            HttpStatus.OK);
    }

    public InterviewReviewController() {
        this.interviewReviewMapper = new InterviewReviewMapper();
    }
}
