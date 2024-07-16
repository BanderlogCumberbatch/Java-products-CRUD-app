package com.example.app.controller;

import com.example.app.model.Product;

import com.example.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Методы для обработки запросов

    @GetMapping
    public ModelAndView getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView editPage(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView editProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        productService.updateProduct(product);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView addPage() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView addProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        productService.createProduct(product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        productService.deleteProduct(id);
        return modelAndView;
    }

}