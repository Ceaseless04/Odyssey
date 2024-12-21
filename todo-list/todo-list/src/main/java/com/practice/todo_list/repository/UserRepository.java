package com.practice.todo_list.repository;

import com.practice.todo_list.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
