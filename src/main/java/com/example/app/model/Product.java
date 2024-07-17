package com.example.app.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;
    
    @Column(name = "article_number", unique = true)
    private String articleNumber; // Артикул
    
    @Column(name = "name")
    private String name; // Название

    @Column(name = "description")
    private String description; // Описание

    @Column(name = "category")
    private String category; // Категория товара

    @Column(name = "price")
    private Double price; // Цена

    @Column(name = "quantity")
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

}
