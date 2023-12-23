package com.blogging.blogappapis.repositories;

import com.blogging.blogappapis.entities.CategoryEntity;
import com.blogging.blogappapis.entities.PostsEntity;
import com.blogging.blogappapis.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<PostsEntity,Integer> {


    List<PostsEntity>  findByUserEntity(UserEntity userEntity);
    List<PostsEntity> findByCategoryEntity(CategoryEntity categoryEntity);
}
