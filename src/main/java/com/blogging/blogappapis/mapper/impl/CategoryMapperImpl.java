package com.blogging.blogappapis.mapper.impl;

import com.blogging.blogappapis.entities.CategoryEntity;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.payloads.CategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements Mapper<CategoryEntity, CategoryDto> {

    public ModelMapper modelMapper;

    @Autowired
    public  CategoryMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @Override
    public CategoryEntity mapTo(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, CategoryEntity.class);
    }

    @Override
    public CategoryDto mapFrom(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDto.class);
    }
}
