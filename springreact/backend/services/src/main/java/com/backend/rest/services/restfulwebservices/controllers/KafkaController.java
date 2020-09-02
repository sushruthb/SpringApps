package com.backend.rest.services.restfulwebservices.controllers;

import com.backend.rest.services.restfulwebservices.model.Todo;
import com.backend.rest.services.restfulwebservices.services.KafkaService;
import com.backend.rest.services.restfulwebservices.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;
    @GetMapping("/startkafka")
    public void  startKafka() throws IOException, InterruptedException {
         kafkaService.startKafka();
    }

    @GetMapping("/stopkafka")
    public void  stopKafka() throws IOException, InterruptedException {
        kafkaService.stopKafka();
    }
}
