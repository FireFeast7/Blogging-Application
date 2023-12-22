package com.blogging.blogappapis.services;

import com.blogging.blogappapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

    void deleteCategory(Integer cat_id);

    CategoryDto getCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategory();

}
