package com.backend.rest.services.restfulwebservices.controllers;

import com.backend.rest.services.restfulwebservices.model.Todo;
import com.backend.rest.services.restfulwebservices.repository.TodoRepository;
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
public class TodoJpaController {

    @Autowired
    private TodoService todoService;
    private TodoRepository todoRepository;

    @GetMapping("/jpa/users/{username}/todos")
    List<Todo> getAllTodos(@PathVariable String username){
        return todoRepository.findAll();
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable long id){
        return todoRepository.findById(id).get();
    }

    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id,
                                           @RequestBody Todo todo){
                todo.setUsername(username);
                Todo todoUpdated=todoRepository.save(todo);
                return new ResponseEntity<Todo>(todo,HttpStatus.OK);

    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username,
                                           @RequestBody Todo todo){
        todo.setUsername(username);
        Todo createdTodo=todoRepository.save(todo);
        //Location
        //Get current resource URL
        //{id}
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}
