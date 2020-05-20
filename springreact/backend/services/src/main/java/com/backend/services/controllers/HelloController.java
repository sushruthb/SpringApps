package com.backend.services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String Hello(){
        return "Hello";
    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello");
    }
    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(String name){
        return new HelloWorldBean(String.format("Hello, %s",name));

    }
}
