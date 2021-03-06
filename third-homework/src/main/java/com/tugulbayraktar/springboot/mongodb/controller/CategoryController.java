package com.tugulbayraktar.springboot.mongodb.controller;

import com.tugulbayraktar.springboot.mongodb.dto.CategoryDto;
import com.tugulbayraktar.springboot.mongodb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public CategoryDto findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> insertCategory(@Valid @RequestBody CategoryDto categoryDto) {
        categoryDto = categoryService.insertCategory(categoryDto);
        if (categoryDto != null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(categoryDto.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body("Something went wrong..");
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCategoryById(@RequestParam String id) {
        Long deletedCount = categoryService.deleteCategoryById(id);
        if (deletedCount > 0) {
            return ResponseEntity.ok("ID: " + id + "\n " + deletedCount + " entry found and deleted.");
        }
        return ResponseEntity.notFound().header("message", "Entry " + id + " does not exist.").build();
    }
}
