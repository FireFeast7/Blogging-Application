package com.blogging.blogappapis.mapper.impl;

import com.blogging.blogappapis.entities.UserEntity;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.payloads.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {

    private ModelMapper modelMapper;

    @Autowired
    public UserMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @Override
    public UserEntity mapTo(UserDto userDto) {
        return modelMapper.map(userDto,UserEntity.class);
    }

    @Override
    public UserDto mapFrom(UserEntity userEntity) {
        return modelMapper.map(userEntity,UserDto.class);
    }
}
