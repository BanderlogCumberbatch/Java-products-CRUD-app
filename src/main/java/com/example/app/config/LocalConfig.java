package com.example.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.app.model.Product;
import com.example.app.service.ProductService;

@Configuration
@Profile("local")
public class LocalConfig {
    @Autowired
	private final ProductService productService;
	public LocalConfig(ProductService productService) {
		this.productService = productService;
	}
    
    @Bean
	public CommandLineRunner demo() {
		return args -> {
			Product product = new Product();
			product.setArticleNumber("AN011");
			product.setName("Product 1");
			product.setDescription("Description 1");
			product.setCategory("Category 1");
			product.setPrice(10.);
			product.setQuantity(5);
			productService.createProduct(product);

			Product savedProduct = productService.getProductById(product.getId());
			System.out.println("Saved Product: " + savedProduct);

		};
		
	}
}
