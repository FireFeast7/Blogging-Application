package com.blogging.blogappapis.controllers;

import com.blogging.blogappapis.entities.UserEntity;
import com.blogging.blogappapis.exceptions.GlobalExceptionHandler;
import com.blogging.blogappapis.payloads.UserDto;
import com.blogging.blogappapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/")
    private ResponseEntity<UserDto> createUser(@Valid
            @RequestBody UserDto userDto
    )  {
        UserDto createdUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
    }

    @GetMapping(path = "/")
    private List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

   @PutMapping(path = "/{userId}")
    private ResponseEntity<UserDto> getUpdatedUser(
            @Valid
            @PathVariable("userId") Integer userId,
            @RequestBody UserDto userDto
   ){
        UserDto userDto1 = userService.UpdateUser(userDto,userId);
        return new ResponseEntity<>(userDto1,HttpStatus.OK);
   }

    @DeleteMapping("/{userId}")
    private ResponseEntity deleteUser(
            @PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity(Map.of("message","user Deleted Successfully"),HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{userId}")
    private ResponseEntity<UserDto> getUserById(
            @PathVariable("userId") Integer userId
    ){
        UserDto userDto = userService.getUserbyId(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

}
