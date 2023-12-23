package com.blogging.blogappapis.controllers;

import com.blogging.blogappapis.entities.CategoryEntity;
import com.blogging.blogappapis.payloads.CategoryDto;
import com.blogging.blogappapis.repositories.CategoryRepository;
import com.blogging.blogappapis.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService,CategoryRepository categoryRepository){
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping(path = "/" )
    public ResponseEntity<CategoryDto> createUser(@Validated
      @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> updateUser(
            @PathVariable("id" )Integer id,
            @RequestBody CategoryDto categoryDto
    ){
        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto,id);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable("id") Integer id
    ){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(
            @PathVariable("id") Integer id
    ){
        CategoryDto categoryDto = categoryService.getCategory(id);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllCategory(){
        List<CategoryDto> categoryEntities = categoryService.getAllCategory();
        return  new ResponseEntity<>(categoryEntities,HttpStatus.OK);
    }
}
