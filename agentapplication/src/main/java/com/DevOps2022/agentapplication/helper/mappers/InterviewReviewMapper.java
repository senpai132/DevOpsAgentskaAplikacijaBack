package com.DevOps2022.agentapplication.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.agentapplication.helper.dto.InterviewReviewDTO;
import com.DevOps2022.agentapplication.model.InterviewReview;

public class InterviewReviewMapper implements MapperInterface<InterviewReview, InterviewReviewDTO>{

    @Override
    public InterviewReview toEntity(InterviewReviewDTO dto) {
        InterviewReview review = new InterviewReview();
        review.setId(dto.getId());
        review.setAuthor(dto.getAuthor());
        review.setCompany(dto.getCompany());
        review.setHrInterview(dto.getHrInterview());
        review.setPosition(dto.getPosition());
        review.setTechnicalInterview(dto.getTechnicalInterview());
        
        return review;
    }

    @Override
    public List<InterviewReview> toEntityList(List<InterviewReviewDTO> dtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InterviewReviewDTO toDto(InterviewReview entity) {
        InterviewReviewDTO dto = new InterviewReviewDTO();
        dto.setId(entity.getId());
        dto.setAuthor(entity.getAuthor());
        dto.setCompany(entity.getCompany());
        dto.setHrInterview(entity.getHrInterview());
        dto.setPosition(entity.getPosition());
        dto.setTechnicalInterview(entity.getTechnicalInterview());
        dto.setTimestamp(entity.getTimestamp());
        
        return dto;
    }

    @Override
    public List<InterviewReviewDTO> toDtoList(List<InterviewReview> entityList) {
        List<InterviewReviewDTO> dtoList = new ArrayList<InterviewReviewDTO>();
        
        for(InterviewReview review: entityList) {
            dtoList.add(toDto(review));
        }
        
        return dtoList;
    }
    
}
