package com.mnt.employee;

import com.mnt.employee.Service.EmployeeService;
import com.mnt.employee.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeService employeeService)
	{
		return runner -> {

			//createEmployee(employeeService);
			//updateEmployee(employeeService);

		};
	}

	public void createEmployee(EmployeeService employeeService)
	{
		Employee employee = new Employee(
				"uday", "reddy",
				"uday.doe@example.com",
				"Engineering",
				95000.00
		);
		employeeService.save(employee);
		System.out.println("Employee saved successfully.");
	}

	public void updateEmployee(EmployeeService employeeService)
	{
		Employee employee = employeeService.findEmployeeById(11);
		employee.setEmail("uday.reddy@gmail.com");
		employeeService.updateEmployee(employee);
		System.out.println("Employee updated successfully.");
	}







}
