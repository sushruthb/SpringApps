package com.backend.rest.services.services;

import com.backend.rest.services.model.Todo;
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
