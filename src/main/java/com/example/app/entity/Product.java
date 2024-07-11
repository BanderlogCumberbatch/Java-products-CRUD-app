package com.example.app.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    
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
    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }
            
    public void setId(Long id) {
        this.id = id;
    }

    public void setArticle(String articleNumber) {
        this.articleNumber = articleNumber;
    }
            
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
