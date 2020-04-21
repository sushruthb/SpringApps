package com.catalog.product.controller;

import com.catalog.product.model.Product;
import com.catalog.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController  {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/products")
    public String viewProductsPage(Model model){
        List<Product> listProducts=service.listAll();
        model.addAttribute("listProducts",listProducts);

        return "products";

    }
    @GetMapping("/productsid")
    public Long viewProductsId(Model model,Long id){
        Product productsid=service.get(id);
        model.addAttribute("listProducts",productsid);

        return productsid;

    }
    @GetMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
               return "redirect:/new_product";
        }
        else{
            service.save(product);
            return "redirect:/products";
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/products";
    }

}
