package com.mnt.productinv;

import com.mnt.productinv.entity.Product;
import com.mnt.productinv.repository.ProductRepository;
import com.mnt.productinv.service.ProductService;
import com.mnt.productinv.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class ProductinvApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductinvApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductService productService)
	{
		return runner -> {

			//save(productService);
			//update(productService, 10);
			//delete(productService,10);

		};
	}
	private void save(ProductService productService) throws ParseException {
		Product product = new Product();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		product.setProductName("Running shoes - impacto");
		product.setBrand("Impackto-ajanta");
		product.setCategory("FootWare");
		product.setPrice(987.0); // or 987
		product.setQuantity(1);
		product.setManufactureDate(sdf.parse("2026-03-20"));
		product.setExpiryDate(sdf.parse("2028-03-20"));

		productService.save(product);
	}
	private void update(ProductService productService, int id)
	{
		Product product = productService.findByProductId(id);
		product.setPrice(1000.00);
		product.setCategory("Footwear");
		product.setProductName("Walking shoes");

		productService.save(product);
	}

	private void delete(ProductService productService, int id)
	{
		Product product = productService.findByProductId(id);
		productService.delete(product);
	}



}
