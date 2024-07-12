package com.example.app.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "products")
public class Product {
    // Конструктор без аргументов
    public Product() {
    }

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

    public String getArticle() {
        return articleNumber;
    }

    public void setArticle(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }
            
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

}
