package com.mnt.schoolapp.service;

import com.mnt.schoolapp.entity.Student;
import com.mnt.schoolapp.repository.StudentDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    public List<Student> getAllStudents()
    {
        return studentDAO.findAll();
    }


    public Student findById(int id)
    {
        return studentDAO.findById(id);
    }

}
