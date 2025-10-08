package de.aittr.product;

import de.aittr.product.repository.ProductRepository;
import de.aittr.product.repository.ProductRepositoryJdbcImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

		//ProductRepository repository = new ProductRepositoryJdbcImpl();
		//System.out.println(repository.findAll());


	}

}
