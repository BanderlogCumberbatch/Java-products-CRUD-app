package com.example.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.app.model.Product;
import com.example.app.repository.ProductRepository;

/**
 * Класс обслуживания для управления продуктами.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CRUD методы

    /**
     * Возвращает все продукты.
     *
     * @return список продуктов
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll(Sort.by("articleNumber"));
    }

    /**
     * Возвращает продукт по его ID.
     *
     * @param id ID продукта
     * @return продукт с определенным ID
     */
    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Сохраняет продукт.
     *
     * @param product сохраняемый продукт
     * @return сохраненный продукт
     */
    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }

    /**
     * Удаляет продукт по его ID.
     *
     * @param id ID удаляемого продукта
     */
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
