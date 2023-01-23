package com.DevOps2022.agentapplication.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.agentapplication.helper.dto.SalaryDTO;
import com.DevOps2022.agentapplication.model.SalaryReview;

public class SalaryMapper implements MapperInterface<SalaryReview, SalaryDTO> {

    @Override
    public SalaryReview toEntity(SalaryDTO dto) {
        SalaryReview review = new SalaryReview();
        review.setAmount(dto.getAmount());
        review.setCompany(dto.getCompany());
        review.setJobtitle(dto.getJobtitle());
        
        return review;
    }

    @Override
    public List<SalaryReview> toEntityList(List<SalaryDTO> dtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SalaryDTO toDto(SalaryReview entity) {
        SalaryDTO dto = new SalaryDTO();
        dto.setAmount(entity.getAmount());
        dto.setCompany(entity.getCompany());
        dto.setId(entity.getId());
        dto.setJobtitle(entity.getJobtitle());
        dto.setTimestamp(entity.getTimestamp());

        return dto;
    }

    @Override
    public List<SalaryDTO> toDtoList(List<SalaryReview> entityList) {
        List<SalaryDTO> dtoList = new ArrayList<SalaryDTO>();
        for(SalaryReview entity : entityList)
            dtoList.add(toDto(entity));
        
        return dtoList;
    }
    
}
