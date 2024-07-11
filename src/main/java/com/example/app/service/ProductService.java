package com.example.app.service;

import com.example.app.entity.Product;
import com.example.app.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CRUD методы

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Product Product) {
        return productRepository.save(Product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
