package com.spring.starter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.starter.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> { 
    User findByUsername(String username);
}