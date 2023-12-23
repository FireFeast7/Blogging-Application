package com.blogging.blogappapis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer posts_id;

    private String imageName;

    private String content;

    private String title;

    private Date addedData;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)                          // changes name of the column
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userEntity;
}
