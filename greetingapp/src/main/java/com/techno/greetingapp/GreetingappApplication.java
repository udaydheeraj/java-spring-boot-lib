package com.techno.greetingapp;

import com.techno.greetingapp.beans.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GreetingappApplication {

	public static void main(String[] args) {


		ApplicationContext context= SpringApplication.run(GreetingappApplication.class, args);
		/*Student student = context.getBean(Student.class);
		Student student2 = context.getBean(Student.class);
		System.out.println(student2==student);*/




	}

}
