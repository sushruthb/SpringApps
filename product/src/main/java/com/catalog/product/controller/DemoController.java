package com.catalog.product.controller;

import com.catalog.product.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
@Controller
public class DemoController
{
    @GetMapping("/demo")
    public String index()
    {
        return"index1";
    }
    @PostMapping("/savedata")
    public ModelAndView save(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    public class vueController {
        @GetMapping("/vue")
        public String index(Model model) {
            model.addAttribute("eventName", "FIFA 2018");
            return "vueindex";
        }
    }
}