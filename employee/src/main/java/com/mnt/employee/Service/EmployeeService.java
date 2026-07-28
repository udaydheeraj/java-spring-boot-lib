package com.mnt.employee.Service;

import com.mnt.employee.entity.Employee;
import com.mnt.employee.repository.EmployeeDAOimpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeDAOimpl employeeDAOimpl;

    public EmployeeService(EmployeeDAOimpl employeeDAOimpl) {

        this.employeeDAOimpl = employeeDAOimpl;
    }

    public void save(Employee employee)
    {
        employeeDAOimpl.save(employee);
    }

    public List<Employee> getAllEmployees()
    {
        return employeeDAOimpl.findAll();
    }

    public Employee findEmployeeById(int id)
    {
        return employeeDAOimpl.findEmployeeById(id);
    }

    public void updateEmployee(Employee employee)
    {
        employeeDAOimpl.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDAOimpl.deleteEmployee(employee);
    }

    public List<Employee> getEmployeeByDepartment(String department)
    {
        return employeeDAOimpl.findEmployeeByDepartment(department);
    }
}
