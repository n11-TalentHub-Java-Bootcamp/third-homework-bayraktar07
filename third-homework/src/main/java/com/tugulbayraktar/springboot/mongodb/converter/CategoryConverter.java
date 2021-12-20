package com.tugulbayraktar.springboot.mongodb.converter;

import com.tugulbayraktar.springboot.mongodb.dto.CategoryDto;
import com.tugulbayraktar.springboot.mongodb.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    CategoryDto convertCategoryToCategoryDto (Category category);

    List<CategoryDto> convertAllCategoryListToCategoryDtoList (List<Category> categories);

    Category convertCategoryDtoToCategory(CategoryDto categoryDto);
}
