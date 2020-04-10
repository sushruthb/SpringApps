package com.spring.restservice.restcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetController {
    @GetMapping("/greet")
    public String greet(@RequestParam(name="name",required=false, defaultValue="World") String name, Model model){
            model.addAttribute("name",name);
            return "index";
    }

    @GetMapping("/greets")
    public String greets(){
              return "names";

    }
}
