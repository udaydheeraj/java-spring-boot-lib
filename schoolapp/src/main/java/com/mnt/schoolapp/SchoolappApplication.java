package com.mnt.schoolapp;

import com.mnt.schoolapp.entity.Student;
import com.mnt.schoolapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.StubNotFoundException;
import java.util.List;

@SpringBootApplication
public class SchoolappApplication {

	public static void main(String[] args) {

		SpringApplication.run(SchoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService)
	{
		return runner -> {
			//updateStudent(studentService);

		};
	}

	private void insertStudent(StudentService studentService) {
		Student student = new Student(
				"Rahul",
				"Sharma",
				18,
				"12th");

		studentService.saveStudent(student);

		System.out.println("Student saved successfully.");
	}

	private void updateStudent(StudentService studentService)
	{
		Student student = studentService.findById(6);

		student.setAge(22);
		studentService.updateStudent(student);
		System.out.println("Student saved successfully.");
	}

	private void deleteStudent(StudentService studentService) {
		// delete logic
		studentService.deleteById(1);
		System.out.println("Student  deleted");
	}

	private void printStudents(StudentService studentService) {
		// display logic
		studentService.getAllStudents().forEach(System.out::println);

	}

}
