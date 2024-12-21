package com.practice.todo_list.repository;

import com.practice.todo_list.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// Use interfaces with Repositories, allow to access Beans
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByUserId(String userId);
}
