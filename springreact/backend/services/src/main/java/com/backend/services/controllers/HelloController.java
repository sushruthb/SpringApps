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
        new HelloWorldBean("Hello");
    }
}
