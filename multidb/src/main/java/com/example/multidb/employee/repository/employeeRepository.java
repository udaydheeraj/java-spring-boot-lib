package com.example.multidb.employee.repository;

import com.example.multidb.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository  extends JpaRepository<Employee, Integer> {
}
