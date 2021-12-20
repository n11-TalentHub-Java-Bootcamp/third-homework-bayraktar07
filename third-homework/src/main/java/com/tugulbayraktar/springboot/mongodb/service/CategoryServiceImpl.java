package com.tugulbayraktar.springboot.mongodb.service;

import com.tugulbayraktar.springboot.mongodb.converter.CategoryConverter;
import com.tugulbayraktar.springboot.mongodb.dto.CategoryDto;
import com.tugulbayraktar.springboot.mongodb.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryEntityService categoryEntityService;

    public List<CategoryDto> findAll() {
        return categoryEntityService.findAll();
    }

    public CategoryDto findById(String id) {
        return categoryEntityService.findById(id);
    }

    public CategoryDto insertCategory(CategoryDto categoryDto) {
        return CategoryConverter.INSTANCE.convertCategoryToCategoryDto(categoryEntityService.insertCategory(categoryDto));
    }

    public Long deleteCategoryById(String id) {
        return categoryEntityService.deleteCategoryById(id);
    }
}
