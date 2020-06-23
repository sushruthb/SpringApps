package com.backend.rest.services.restfulwebservices.controllers;

import com.backend.rest.services.restfulwebservices.model.Todo;
import com.backend.rest.services.restfulwebservices.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable long id){
        return todoService.findByid(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo=todoService.deleteById(id);
        if(todo!=null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id,
                                           @RequestBody Todo todo){
                Todo todoUpdated=todoService.save(todo);
                return new ResponseEntity<Todo>(todo,HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @RequestBody Todo todo){
        Todo createdTodo=todoService.save(todo);
        //Location
        //Get current resource URL
        //{id}
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}
