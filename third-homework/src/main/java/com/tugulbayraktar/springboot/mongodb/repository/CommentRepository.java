package com.tugulbayraktar.springboot.mongodb.repository;


import com.tugulbayraktar.springboot.mongodb.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository <Comment, String> {
}
