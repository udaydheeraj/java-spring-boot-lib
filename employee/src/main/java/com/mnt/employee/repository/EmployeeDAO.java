package com.mnt.employee.repository;

import com.mnt.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void save(Employee employee);

    public List<Employee> findAll();

    public Employee findEmployeeById(int id);

    public void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> findEmployeeByDepartment(String department);
}
