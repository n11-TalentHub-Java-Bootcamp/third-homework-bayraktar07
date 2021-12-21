package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();

    CommentDto findCommentById(String id);

    CommentDto saveComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto);

    Long deleteCommentById(String id);
}
