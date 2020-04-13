package com.catalog.product.controller;

import com.catalog.product.model.Product;
import com.catalog.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class ProductController  {
    @Autowired
    private ProductService service;


    @GetMapping("/")
    public String welcomePage(){

        return "index";

    }
    @GetMapping("/products")
    public String viewHomePage(Model model){
        List<Product> listProducts=service.listAll();
        model.addAttribute("listProducts",listProducts);

        return "Hello";

    }

}
