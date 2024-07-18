package com.example.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.app.model.Product;
import com.example.app.repository.ProductRepository;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId(UUID.randomUUID());
        product.setArticleNumber("12345");
        product.setName("Test Product");
        product.setPrice(100.0);
        product.setQuantity(10);
    }

    @Test
    public void testReadProduct() {
        UUID productId = product.getId();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = Optional.of(productService.getProductById(productId));

        assertTrue(foundProduct.isPresent());
        assertEquals(product.getName(), foundProduct.get().getName());
    }

    @Test
    public void testUpdateProduct() {
        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.updateProduct(product);

        assertNotNull(savedProduct);
        assertEquals(product.getName(), savedProduct.getName());
    }

    @Test
    public void testDeleteProduct() {
        UUID productId = product.getId();
        doNothing().when(productRepository).deleteById(productId);

        productService.deleteProduct(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }
}