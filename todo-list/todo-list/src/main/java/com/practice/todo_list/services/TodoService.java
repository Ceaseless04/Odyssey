package com.practice.todo_list.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practice.todo_list.model.Todo;
import com.practice.todo_list.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getToDosByUser(String userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo createOrUpdateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodoById(String id) {
        todoRepository.deleteById(id);
    }
}
