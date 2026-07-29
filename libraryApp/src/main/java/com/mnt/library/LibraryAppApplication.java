package com.mnt.library;

import com.mnt.library.entity.Category;
import com.mnt.library.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CategoryService categoryService)
	{
		return runner -> {
			//updateCategory(categoryService,1);
		};
	}

	void updateCategory(CategoryService categoryService,Integer id)
	{
		Category category = categoryService.getCatogoryById(id);
		String desc = "Books on programming languages and software development life Cycle";
		category.setDescription(desc);
		categoryService.updateCategory(category,id);
		System.out.println("updated successfully");

	}

}
