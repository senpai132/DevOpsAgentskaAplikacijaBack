package com.DevOps2022.agentapplication.helper.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SalaryDTO {
    private Integer id;
    private String company;
    private String jobtitle;
    private int amount;
    private Date timestamp;
}
