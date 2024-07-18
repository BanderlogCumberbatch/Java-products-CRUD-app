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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Представляет сущность продукта.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;
    
    @NotBlank(message = "Article is mandatory")
    @Column(name = "article_number", unique = true)
    private String articleNumber; // Артикул
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name; // Название

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description; // Описание

    @NotBlank(message = "Category is mandatory")
    @Column(name = "category")
    private String category; // Категория товара

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    @Column(name = "price")
    private Double price; // Цена

    @NotNull(message = "Quantity is mandatory")
    @Positive(message = "Quantity must be positive")
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
