package com.example.app;

import com.example.app.entity.Product;
import com.example.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	@Autowired
	public void MyApp(ProductService productService) {
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return args -> {
			// Здесь можно добавить код для тестирования вашего приложения
			// Например, вызвать методы вашего сервиса для создания, чтения, обновления и
			// удаления данных
			// и выводить результаты на консоль

			// Пример:
			Product product = new Product();
			product.setArticle("AN011");
			product.setName("Product 1");
			product.setDescription("Description 1");
			product.setCategory("Category 1");
			product.setPrice(10.);
			product.setQuantity(5);
			ProductService.createProduct(product);

			Product savedProduct = ProductService.getProductById(product.getId());
			System.out.println("Saved Product: " + savedProduct);

		};
	}

}
