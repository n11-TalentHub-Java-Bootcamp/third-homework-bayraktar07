package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll ();

    CategoryDto findById(String id);

    CategoryDto insertCategory (CategoryDto categoryDto);

    Long deleteCategoryById (String id);
}
