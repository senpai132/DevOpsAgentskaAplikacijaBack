package com.DevOps2022.agentapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevOps2022.agentapplication.helper.dto.CommentDTO;
import com.DevOps2022.agentapplication.helper.mappers.CommentMapper;
import com.DevOps2022.agentapplication.services.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    private CommentMapper commentMapper;
    
    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody CommentDTO dto)
    {
        return new ResponseEntity<String>(commentService.addComment(commentMapper.toEntity(dto)), 
            HttpStatus.CREATED);
    }

    @GetMapping("/getbycompany/{company}")
    public ResponseEntity<List<CommentDTO>> getCommentsByCompany(@PathVariable String company)
    {
        return new ResponseEntity<List<CommentDTO>>(commentMapper.toDtoList(commentService.getCommentsByCompany(company)), 
            HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer id)
    {
        try {
            return new ResponseEntity<String>(commentService.deleteComment(id), 
                HttpStatus.OK);
    
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public CommentController() {
        this.commentMapper = new CommentMapper();
    }
}
