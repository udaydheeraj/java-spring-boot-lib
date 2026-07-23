package com.mnt.schoolapi.service;

import com.mnt.schoolapi.entity.Student;
import com.mnt.schoolapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByGradeLevel(String grade)
    {
        return studentRepository.findStudentsByGradeLevel(grade);
    }

    public List<Student> getStudentsByAge(Integer age)
    {
        return studentRepository.findByAge(age);
    }
}
