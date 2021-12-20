package com.tugulbayraktar.springboot.mongodb.service.entityservice;

import com.tugulbayraktar.springboot.mongodb.converter.CategoryConverter;
import com.tugulbayraktar.springboot.mongodb.dto.CategoryDto;
import com.tugulbayraktar.springboot.mongodb.entity.Category;
import com.tugulbayraktar.springboot.mongodb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryEntityService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> findAll () {
        return CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList (categoryRepository.findAll());
    }

    public CategoryDto findById (String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.map(CategoryConverter.INSTANCE::convertCategoryToCategoryDto).orElse(null);
    }

    public Category insertCategory (CategoryDto categoryDto) {
        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);
        category = categoryRepository.insert(category);
        return category;
    }

    public Long deleteCategoryById (String id) {
        return categoryRepository.deleteCategoryById(id);
    }
}
