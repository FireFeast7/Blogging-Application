package com.blogging.blogappapis.services.impl;

import com.blogging.blogappapis.entities.CategoryEntity;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.mapper.impl.CategoryMapperImpl;
import com.blogging.blogappapis.payloads.CategoryDto;
import com.blogging.blogappapis.repositories.CategoryRepository;
import com.blogging.blogappapis.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final Mapper<CategoryEntity,CategoryDto> categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Mapper<CategoryEntity,CategoryDto> categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        return null;
    }

    @Override
    public void deleteCategory(Integer cat_id) {

    }

    @Override
    public CategoryDto getCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }

    private CategoryEntity DTOtoEntity(CategoryDto categoryDto){
        return categoryMapper.mapTo(categoryDto);
    }

    private CategoryDto EntityToDto(CategoryEntity categoryEntity){
        return categoryMapper.mapFrom(categoryEntity);
    }
}
