package com.DevOps2022.agentapplication.helper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class JobOpeningDTO {
    private Integer id;
    private String title;
    private String seniority;
    private String description;
    private String company; 
}
