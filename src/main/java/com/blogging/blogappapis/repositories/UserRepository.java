package com.blogging.blogappapis.repositories;

import com.blogging.blogappapis.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity , Integer> {
}
