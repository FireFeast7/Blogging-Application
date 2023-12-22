package com.blogging.blogappapis.exceptions;

import com.blogging.blogappapis.exceptions.all.ApiResponse;
import com.blogging.blogappapis.exceptions.all.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodNotFoundValid(MethodArgumentNotValidException man){
        Map<String,String> resp = new HashMap<>();
        man.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError)error).getField();
            String fieldMessage = ((FieldError)error).getDefaultMessage();
            resp.put(fieldName,fieldMessage);
        });
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST );
    }
}
