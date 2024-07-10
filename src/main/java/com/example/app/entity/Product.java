package com.example.app.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String sku; // Артикул
    
    private String name; // Название
    private String description; // Описание
    private String category; // Категория товара
    private Double price; // Цена
    private Integer quantity; // Количество

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModified = LocalDateTime.now();
    }
    // Геттеры и сеттеры
}
