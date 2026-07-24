package com.mnt.schoolapp.repository;

import com.mnt.schoolapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}
