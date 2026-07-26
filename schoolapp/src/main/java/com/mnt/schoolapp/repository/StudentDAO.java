package com.mnt.schoolapp.repository;

import com.mnt.schoolapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    private final EntityManager entityManager;

    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Student student)
    {
        entityManager.persist(student);
    }

    public List<Student> findAll()
    {
       TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
       return query.getResultList();
    }

    public Student findById(int id)
    {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    public void update(Student student)
    {
        entityManager.merge(student);
    }

    @Transactional
    public void deleteById(int id)
    {
        Student student = entityManager.find(Student.class, id);
        if(student != null) {
        entityManager.remove(student);
        }
    }

}
