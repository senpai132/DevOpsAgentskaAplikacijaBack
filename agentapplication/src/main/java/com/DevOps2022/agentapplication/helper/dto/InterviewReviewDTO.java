package com.DevOps2022.agentapplication.helper.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class InterviewReviewDTO {
    private Integer id;   
    private String company;   
    private String position;
    private String hrInterview;
    private String technicalInterview; 
    private Date timestamp;
    private String author; 
}
