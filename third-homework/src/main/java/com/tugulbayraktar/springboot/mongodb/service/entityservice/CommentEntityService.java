package com.tugulbayraktar.springboot.mongodb.service.entityservice;

import com.tugulbayraktar.springboot.mongodb.converter.CommentConverter;
import com.tugulbayraktar.springboot.mongodb.dto.CommentDto;
import com.tugulbayraktar.springboot.mongodb.entity.Comment;
import com.tugulbayraktar.springboot.mongodb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentEntityService {

    @Autowired
    CommentRepository commentRepository;

    public List<CommentDto> findAll() {
        return CommentConverter.INSTANCE.convertCommentListToCommentDtoList(commentRepository.findAll());
    }

    public CommentDto findCommentById(String id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        return commentOptional.map(CommentConverter.INSTANCE::convertCommentToCommentDto).orElse(null);
    }

    public CommentDto saveComment(CommentDto commentDto) {
        Comment comment = CommentConverter.INSTANCE.convertCommentDtoToComment(commentDto);
        comment = commentRepository.insert(comment);
        return CommentConverter.INSTANCE.convertCommentToCommentDto(comment);
    }

    public CommentDto updateComment(CommentDto commentDto) {
        Comment comment = CommentConverter.INSTANCE.convertCommentDtoToComment(commentDto);
        comment = commentRepository.save(comment);
        return CommentConverter.INSTANCE.convertCommentToCommentDto(comment);
    }

    public Long deleteCommentById(String id) {
        return commentRepository.deleteCommentById(id);
    }
}
