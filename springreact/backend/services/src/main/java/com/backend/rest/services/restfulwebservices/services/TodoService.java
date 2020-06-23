package com.backend.rest.services.restfulwebservices.services;

import com.backend.rest.services.restfulwebservices.model.Todo;
import com.backend.rest.services.restfulwebservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository repo;


    private static List<Todo> todos=new ArrayList();
    private static long idCounter=0;
/*

    static{
        todos.add(new Todo(++idCounter,"SpringFullStack","ReactJS",new Date(),false));
        todos.add(new Todo(++idCounter,"SpringFullStack","Spring with ReactJS",new Date(),false));
        todos.add(new Todo(++idCounter,"SpringFullStack","React,ReactJS & MySql",new Date(),false));
    }
*/

    public List<Todo> findAll(){
        return todos;
    }



    public Todo save(Todo todo){
        if (todo.getId()==-1  || todo.getId()==0) {
            todo.setId(++idCounter);
            todos.add(todo);
            }else {
                deleteById(todo.getId());
                todos.add(todo);
            }
            return todo;
    }


    public Todo deleteById(Long id){
        Todo todo=findByid(id);
        if (todo==null) return null;

        if(todos.remove(todo)) {
           return todo;
        }
        return null;
    }

    public Todo findByid(Long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }


}
