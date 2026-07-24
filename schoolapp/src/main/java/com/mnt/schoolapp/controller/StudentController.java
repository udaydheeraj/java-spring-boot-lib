package com.mnt.schoolapp.controller;

import com.mnt.schoolapp.entity.Student;
import com.mnt.schoolapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String saveStudent(@RequestBody Student student) {

        studentService.saveStudent(student);

        return "Student saved successfully.";

    }
}
