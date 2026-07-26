package com.mnt.schoolapp.controller;

import com.mnt.schoolapp.entity.Student;
import com.mnt.schoolapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id)
    {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, Student student)
    {
        student.setStudentId(id);
        studentService.updateStudent(student);

        return "Student updated successfully.";
    }

    @DeleteMapping("/{id}")
    public String deleteById(int id)
    {
        studentService.deleteById(id);
        return "Student deleted successfully.";
    }
}
