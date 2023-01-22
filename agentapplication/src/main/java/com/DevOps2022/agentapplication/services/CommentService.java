package com.DevOps2022.agentapplication.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevOps2022.agentapplication.model.Comment;
import com.DevOps2022.agentapplication.repositories.CommentRepository;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public String addComment(Comment comment) {
        comment.setTimestamp(new Date());
        
        commentRepository.save(comment);

        return "Commnet posted successfully.";
    }

    public String deleteComment(Integer id) throws Exception{
        Optional<Comment> comment = commentRepository.findById(id);

        commentRepository.delete(comment.get());

        return "Comment with id " + id + " deleted successfully.";
    }

    public List<Comment> getCommentsByCompany(String company) {
        return commentRepository.findByCompanyOrderByTimestampDesc(company);
    }
}
