package com.example.app;

import com.example.app.model.Product;
import com.example.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AppApplication {
	private final ProductService productService;

	@Autowired
	public AppApplication(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner demo() {
		return args -> {
			// Тесты:
			Product product = new Product();
			product.setArticle("AN011");
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
*/

}
