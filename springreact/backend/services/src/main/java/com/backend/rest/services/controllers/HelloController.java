package com.backend.rest.services.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://10.98.150.174:4200")
@CrossOrigin(origins = "*")
public class HelloController {
    @GetMapping("/")
    public String Hello(){
        return "Hello";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Bean");
    }


    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s",name));

    }
}
