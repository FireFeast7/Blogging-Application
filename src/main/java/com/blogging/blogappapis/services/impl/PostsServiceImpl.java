package com.blogging.blogappapis.services.impl;

import com.blogging.blogappapis.entities.PostsEntity;
import com.blogging.blogappapis.mapper.Mapper;
import com.blogging.blogappapis.payloads.PostsDto;
import com.blogging.blogappapis.repositories.PostsRepository;
import com.blogging.blogappapis.services.PostsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;

    private final Mapper<PostsEntity,PostsDto> postMapper;

    public PostsServiceImpl(PostsRepository postsRepository,Mapper<PostsEntity,PostsDto> postMapper){
        this.postsRepository = postsRepository;
        this.postMapper =postMapper;
    }
    @Override
    public PostsDto createPost(PostsDto postsDto) {
        return null;
    }

    @Override
    public PostsDto updatePost(PostsDto postsDto, Integer id) {
        return null;
    }

    @Override
    public void deletePost(Integer id) {

    }

    @Override
    public PostsDto getPostById(Integer id) {
        return null;
    }

    @Override
    public List<PostsDto> getPostByUserId(Integer userid) {
        return null;
    }

    @Override
    public List<PostsDto> getAllPosts() {
        return null;
    }

    @Override
    public List<PostsDto> getPostsByCategory(Integer category_id) {
        return null;
    }
}
