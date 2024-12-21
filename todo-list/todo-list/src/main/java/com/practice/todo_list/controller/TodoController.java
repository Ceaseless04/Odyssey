package com.practice.todo_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.todo_list.model.Todo;
import com.practice.todo_list.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(@RequestParam String userId) {
        return todoService.getToDosByUser(userId);
    }

    @PostMapping
    public Todo createOrUpdateTodo(@RequestBody Todo todo) {
        return todoService.createOrUpdateTodo(todo);
    }

    @DeleteMapping
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodoById(id);
    }
}
