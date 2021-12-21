package com.tugulbayraktar.springboot.mongodb.controller;

import com.tugulbayraktar.springboot.mongodb.dto.CommentDto;
import com.tugulbayraktar.springboot.mongodb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<CommentDto> findAll() {
        return commentService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findCommentById (@PathVariable String id) {
        CommentDto commentDto = commentService.findCommentById(id);
        if(commentDto != null) {
            ResponseEntity.ok(commentDto);
        }
        return ResponseEntity.noContent().header("message", id + "Not found.").build();
    }

    @PostMapping
    public ResponseEntity<Object> saveComment(@RequestBody CommentDto commentDto) {
        CommentDto savedComment = commentService.saveComment(commentDto);
        if(savedComment != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(savedComment.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @PutMapping
    public ResponseEntity<Object> updateComment(@RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(commentDto);
        if(updatedComment != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(updatedComment.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCommentById(@RequestParam String id) {
        Long deletedCount = commentService.deleteCommentById(id);
        if(deletedCount > 0) {
            return ResponseEntity.ok("ID: " + id + "\n " + deletedCount + " entry found and deleted.");
        }
        return ResponseEntity.notFound().header("message", "Entry " + id + " does not exist.").build();
    }
}
