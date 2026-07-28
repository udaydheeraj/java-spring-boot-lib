package com.mnt.employee.repository;

import com.mnt.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {

   private final EntityManager entityManager;
  // private final String jpql = "FROM Employee WHERE salary> :salar";

    public EmployeeDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        //TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll", Employee.class);
         //Query query1 = entityManager.createNamedQuery("FROM Employee");
      // TypedQuery<Employee> query = entityManager.createQuery("from Employee e where e.salary > 80000",Employee.class);
            //  query.setParameter("salar", 80000);
      return query.getResultList();
    }

    @Override
    @org.springframework.data.jpa.repository.Query("SELECT s from Employee WHERE s.employee_id = :id")
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class,id);
    }



    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public List<Employee> findEmployeeByDepartment(String department) {
       TypedQuery<Employee> query =  entityManager.createQuery("from Employee where department = :department",Employee.class);
       query.setParameter("department",department);
        return query.getResultList();
    }


}
