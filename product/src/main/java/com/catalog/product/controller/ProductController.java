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
import java.util.Map;

@Controller
public class ProductController  {
    @Autowired
    private ProductService service;

    @GetMapping(value = "/")
    public String viewLogin() {

        return "login";
    }

    @PostMapping(value = "/login")
    public String doLogin(@Valid @ModelAttribute("login")
                                      BindingResult result, Map<String, Object> model) {

        if (result.hasErrors()) {
            return "login";
        }

        return "products";
    }

    @GetMapping("/index")
    public String viewHomePage(Model model){
        model.addAttribute("productName","Products");
        return "index";
    }

    @GetMapping("/products")
    public String viewProductsPage(Model model){
        List<Product> listProducts=service.listAll();
        model.addAttribute("listProducts",listProducts);

        return "products";

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
