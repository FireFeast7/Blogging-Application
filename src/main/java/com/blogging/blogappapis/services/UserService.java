package com.blogging.blogappapis.services;

import com.blogging.blogappapis.entities.UserEntity;
import com.blogging.blogappapis.payloads.UserDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto UpdateUser(UserDto userDto,Integer id);

    UserDto getUserbyId(Integer id);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);


}
