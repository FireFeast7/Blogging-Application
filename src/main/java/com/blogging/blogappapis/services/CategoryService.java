package com.blogging.blogappapis.services;

import com.blogging.blogappapis.entities.CategoryEntity;
import com.blogging.blogappapis.payloads.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

    void deleteCategory(Integer cat_id);

    CategoryDto getCategory(Integer id);

    List<CategoryDto> getAllCategory();

}
