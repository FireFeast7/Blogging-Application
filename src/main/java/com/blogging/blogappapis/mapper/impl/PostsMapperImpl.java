package com.blogging.blogappapis.mapper.impl;

import com.blogging.blogappapis.entities.PostsEntity;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.payloads.PostsDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostsMapperImpl implements Mapper<PostsEntity, PostsDto> {

    private final ModelMapper modelMapper;
    @Autowired
    public PostsMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @Override
    public PostsEntity mapTo(PostsDto postsDto) {
        return modelMapper.map(postsDto,PostsEntity.class);
    }

    @Override
    public PostsDto mapFrom(PostsEntity postsEntity) {
        return modelMapper.map(postsEntity,PostsDto.class);
    }
}
