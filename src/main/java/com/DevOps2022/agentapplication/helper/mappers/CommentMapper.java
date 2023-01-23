package com.DevOps2022.agentapplication.helper.mappers;

import java.util.ArrayList;
import java.util.List;

import com.DevOps2022.agentapplication.helper.dto.CommentDTO;
import com.DevOps2022.agentapplication.model.Comment;

public class CommentMapper implements MapperInterface<Comment, CommentDTO>{

    @Override
    public Comment toEntity(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setAuthor(dto.getAuthor());
        comment.setCompany(dto.getCompany());
        comment.setContent(dto.getContent());
        return comment;
    }

    @Override
    public List<Comment> toEntityList(List<CommentDTO> dtoList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommentDTO toDto(Comment entity) {
        CommentDTO dto = new CommentDTO();
        dto.setAuthor(entity.getAuthor());
        dto.setCompany(entity.getCompany());
        dto.setContent(entity.getContent());
        dto.setId(entity.getId());
        dto.setTimestamp(entity.getTimestamp());

        return dto;
    }

    @Override
    public List<CommentDTO> toDtoList(List<Comment> entityList) {
        List<CommentDTO> dtoList = new ArrayList<CommentDTO>();
        for(Comment entity : entityList)
            dtoList.add(toDto(entity));

        return dtoList;
    }
    
}
