package com.DevOps2022.agentapplication.helper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CompanyDTO {
    private Integer id;
    private String name;
    private String owner;
    private String culture;
    private String description;
    private String address;
    private Boolean status;
    private String phoneNumber;
    private String emailAddress;
}
