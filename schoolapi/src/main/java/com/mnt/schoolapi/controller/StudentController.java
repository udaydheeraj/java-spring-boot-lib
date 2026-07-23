package com.mnt.schoolapi.controller;

import com.mnt.schoolapi.entity.Student;
import com.mnt.schoolapi.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return service.getAllStudents();
    }

    @GetMapping("/students/grade/{grade}")
    public List<Student> getStudentsByGradeLevel(@PathVariable String grade)
    {
        return service.getStudentsByGradeLevel(grade);
    }

    @GetMapping("/students/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable Integer age)
    {
        return service.getStudentsByAge(age);
    }
}
