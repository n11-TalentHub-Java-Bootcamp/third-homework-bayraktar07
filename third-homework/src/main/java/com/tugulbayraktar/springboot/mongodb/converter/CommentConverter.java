package com.tugulbayraktar.springboot.mongodb.converter;

import com.tugulbayraktar.springboot.mongodb.dto.CommentDto;
import com.tugulbayraktar.springboot.mongodb.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    Comment convertCommentDtoToComment(CommentDto commentDto);

    CommentDto convertCommentToCommentDto(Comment comment);

    List<CommentDto> convertCommentListToCommentDtoList(List<Comment> commentList);
}
