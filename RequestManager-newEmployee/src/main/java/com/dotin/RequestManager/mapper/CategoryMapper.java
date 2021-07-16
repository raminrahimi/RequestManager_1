package com.dotin.RequestManager.mapper;

import com.dotin.RequestManager.dto.CategoryDto;
import com.dotin.RequestManager.entity.Category;

public class CategoryMapper {

    public Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.getActive());
        category.setDisable(categoryDto.getDisable());
        return category;
    }

    public CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setActive(category.getActive());
        categoryDto.setDisable(category.getDisable());
        return categoryDto;
    }
}
