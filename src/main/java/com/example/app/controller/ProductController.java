package com.example.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.app.model.Product;
import com.example.app.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {
    @Autowired
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Методы для обработки запросов
    @GetMapping
    @Tag(name="Получить все продукты", description="Начальная страница (получение информации о всех продуктах и вывод в таблицу)")
    public ModelAndView getAllProducts() {
        List<Product> products = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    @Tag(name="Страница изменения", description="Страница для ввода информации для изменения записи с определённым id")
    public ModelAndView editPage(@PathVariable UUID id) {
        Product product = productService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/update")
    @Tag(name="Изменить продукт", description="Изменение записи и переадресация на начальную страницу")
    public ModelAndView editProduct(@Valid @ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        productService.updateProduct(product);
        return modelAndView;
    }

    @GetMapping("/create")
    @Tag(name="Страница добавления", description="Страница для ввода информации для добавления новой записи")
    public ModelAndView addPage() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/create")
    @Tag(name="Добавить продукт", description="Добавление записи и переадресация на начальную страницу")
    public ModelAndView addProduct(@Valid @ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        productService.createProduct(product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    @Tag(name="Удалить продукт", description="Удаления записи с определённым id и переадресация на начальную страницу")
    public ModelAndView deleteProduct(@PathVariable UUID id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        productService.deleteProduct(id);
        return modelAndView;
    }

}