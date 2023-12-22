package com.blogging.blogappapis.services.impl;

import com.blogging.blogappapis.entities.UserEntity;
import com.blogging.blogappapis.exceptions.GlobalExceptionHandler;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.payloads.UserDto;
import com.blogging.blogappapis.exceptions.all.ResourceNotFoundException;
import com.blogging.blogappapis.repositories.UserRepository;
import com.blogging.blogappapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private Mapper<UserEntity,UserDto> userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,Mapper<UserEntity,UserDto> userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDto createUser(UserDto userDto)  {
        UserEntity userEntity = this.DTOToUser(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);

        return this.UserToDTO(savedUserEntity);
    }

    @Override
    public UserDto UpdateUser(UserDto userDto, Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("USER","id",id));
        userEntity.setName(userDto.getName());
        userEntity.setAbout(userDto.getAbout());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        UserEntity updatedUser = userRepository.save(userEntity);
        return this.UserToDTO(updatedUser);
    }

    @Override
    public UserDto getUserbyId(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("USER","id",id));
        return UserToDTO(userEntity);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(this::UserToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
      UserEntity userEntity =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("USER","id",userId));
      userRepository.delete(userEntity);
    }

    private UserEntity DTOToUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity = userMapper.mapTo(userDto);
//        userEntity.setId(userDto.getId());
//        userEntity.setEmail(userDto.getEmail());
//        userEntity.setAbout(userDto.getAbout());
//        userEntity.setPassword(userDto.getPassword());
//        userEntity.setName(userDto.getName());
        return userEntity;
    }

    private UserDto UserToDTO(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto = userMapper.mapFrom(userEntity);
//        userDto.setAbout(userEntity.getAbout());
//        userDto.setId(userEntity.getId());
//        userDto.setName(userEntity.getName());
//        userDto.setEmail(userEntity.getEmail());
//        userDto.setPassword(userEntity.getPassword());
        return userDto;
    }
}
