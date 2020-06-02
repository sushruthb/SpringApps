package com.backend.services.services;

import com.backend.services.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList();
    private static int idCounter=0;

    static{
        todos.add(new Todo(++idCounter,"SpringFullStack","ReactJS",new Date(),false));
        todos.add(new Todo(++idCounter,"SpringFullStack","Spring with ReactJS",new Date(),false));
        todos.add(new Todo(++idCounter,"SpringFullStack","React,ReactJS & MySql",new Date(),false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(int id){
        Todo todo=findByid(id);
        if (todo==null) return null;

        if(todos.remove(todo)) {
           return todo;
        }
        return null;
    }

    public Todo findByid(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
