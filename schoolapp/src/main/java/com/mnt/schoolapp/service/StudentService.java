package com.mnt.schoolapp.service;

import com.mnt.schoolapp.entity.Student;
import com.mnt.schoolapp.repository.StudentDAO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void saveStudent(Student student)
    {
        studentDAO.save(student);
    }
}
