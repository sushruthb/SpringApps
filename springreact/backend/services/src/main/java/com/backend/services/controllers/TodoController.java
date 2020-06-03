package com.backend.services.controllers;

import com.backend.services.model.Todo;
import com.backend.services.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;
    @GetMapping("/users/{username}/todos")
    List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable int id){
        return todoService.findByid(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    @CrossOrigin
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
        Todo todo=todoService.deleteById(id);
        if(todo!=null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
