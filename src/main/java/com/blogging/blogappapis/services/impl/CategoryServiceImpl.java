package com.blogging.blogappapis.services.impl;

import com.blogging.blogappapis.entities.CategoryEntity;
import com.blogging.blogappapis.exceptions.all.ResourceNotFoundException;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.mapper.impl.CategoryMapperImpl;
import com.blogging.blogappapis.payloads.CategoryDto;
import com.blogging.blogappapis.repositories.CategoryRepository;
import com.blogging.blogappapis.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        CategoryEntity categoryEntity = this.DTOtoEntity(categoryDto);
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return this.EntityToDto(savedCategoryEntity);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categroy","id",id));
        categoryEntity.setCategoryDescription(categoryDto.getCategoryDescription());
        categoryEntity.setCategoryTitle(categoryDto.getCategoryTitle());
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return this.EntityToDto(savedCategoryEntity);
    }

    @Override
    public void deleteCategory(Integer cat_id) {
        CategoryEntity categoryEntity = categoryRepository.findById(cat_id).orElseThrow(() -> new ResourceNotFoundException("Categroy","id",cat_id));
        categoryRepository.deleteById(cat_id);
    }

    @Override
    public CategoryDto getCategory(Integer id) {
        CategoryEntity categoryEntity1 = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categroy","id",id));
        return EntityToDto(categoryEntity1);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::mapFrom).collect(Collectors.toList());
    }

    private CategoryEntity DTOtoEntity(CategoryDto categoryDto){
        return categoryMapper.mapTo(categoryDto);
    }

    private CategoryDto EntityToDto(CategoryEntity categoryEntity){
        return categoryMapper.mapFrom(categoryEntity);
    }
}
