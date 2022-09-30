package com.DevOps2022.agentapplication.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.agentapplication.helper.dto.JobOpeningDTO;
import com.DevOps2022.agentapplication.model.JobOpening;

public class JobOpeningMapper implements MapperInterface<JobOpening, JobOpeningDTO>{

    @Override
    public JobOpening toEntity(JobOpeningDTO dto) {
        JobOpening job = new JobOpening();
        job.setCompany(dto.getCompany());
        job.setDescription(dto.getDescription());
        job.setSeniority(dto.getSeniority());
        job.setTitle(dto.getTitle());
        return job;
    }

    @Override
    public List<JobOpening> toEntityList(List<JobOpeningDTO> dtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JobOpeningDTO toDto(JobOpening entity) {
        JobOpeningDTO dto = new JobOpeningDTO();
        dto.setCompany(entity.getCompany());
        dto.setDescription(entity.getDescription());
        dto.setId(entity.getId());
        dto.setSeniority(entity.getSeniority());
        dto.setTitle(entity.getTitle());
        return dto;
    }

    @Override
    public List<JobOpeningDTO> toDtoList(List<JobOpening> entityList) {
        List<JobOpeningDTO> dtoList = new ArrayList<JobOpeningDTO>();
        for(JobOpening entity : entityList) 
            dtoList.add(toDto(entity));

        return dtoList;
    }
    
}
