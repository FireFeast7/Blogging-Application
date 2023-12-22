package com.blogging.blogappapis.repositories;

import com.blogging.blogappapis.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
