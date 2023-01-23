package com.DevOps2022.agentapplication.helper.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CommentDTO {
    private int id;
    private String content;
    private String author;
    private Date timestamp;
    private String company;
}
