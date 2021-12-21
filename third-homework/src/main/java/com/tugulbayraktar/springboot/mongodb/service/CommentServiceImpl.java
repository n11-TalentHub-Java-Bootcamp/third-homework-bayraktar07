package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.dto.CommentDto;
import com.tugulbayraktar.springboot.mongodb.service.entityservice.CommentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentEntityService commentEntityService;

    @Override
    public List<CommentDto> findAll() {
        return commentEntityService.findAll();
    }

    @Override
    public CommentDto findCommentById(String id) {
        return commentEntityService.findCommentById(id);
    }

    @Override
    public CommentDto saveComment(CommentDto commentDto) {
        return commentEntityService.saveComment(commentDto);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {
        return commentEntityService.updateComment(commentDto);
    }

    @Override
    public Long deleteCommentById(String id) {
        return commentEntityService.deleteCommentById(id);
    }
}
