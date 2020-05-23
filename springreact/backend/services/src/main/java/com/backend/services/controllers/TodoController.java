package com.backend.services.controllers;

import com.backend.services.model.Todo;
import com.backend.services.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }
}
