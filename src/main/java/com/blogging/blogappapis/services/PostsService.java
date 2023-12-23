package com.blogging.blogappapis.services;

import com.blogging.blogappapis.entities.PostsEntity;
import com.blogging.blogappapis.payloads.PostsDto;

import java.util.List;

public interface PostsService {
    PostsDto createPost(PostsDto postsDto);

    PostsDto updatePost(PostsDto postsDto , Integer id);

    void deletePost(Integer id);

    PostsDto getPostById(Integer id);

    List<PostsDto> getPostByUserId(Integer userid);

    List<PostsDto> getAllPosts();

    List<PostsDto> getPostsByCategory(Integer category_id);

}
