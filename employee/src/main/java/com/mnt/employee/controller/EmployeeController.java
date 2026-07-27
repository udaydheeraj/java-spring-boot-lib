package com.mnt.employee.controller;

import com.mnt.employee.Service.EmployeeService;
import com.mnt.employee.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping
    public void saveEmployee(Employee employee)
    {
        employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employeeService.findEmployeeById(id);
    }

    /*@PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id)
    {
       Employee employee = employeeService.findEmployeeById(id);
       employee.setEmail("uday.reddy@gmail.com");
        employeeService.updateEmployee(employee);

    }*/

   // @DeleteMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.findEmployeeById(id);
        employeeService.deleteEmployee(employee);
        System.out.println("employee deleted Successfully");
        return "<h1>employee deleted Successfully<h1> ";
    }




}
