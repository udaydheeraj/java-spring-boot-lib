package com.techno.greetingapp.controller;

import com.techno.greetingapp.beans.Principle;
import com.techno.greetingapp.beans.Student;
import com.techno.greetingapp.beans.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${system.username}")
    private String username;

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello()
    {
        log.info("Someone visited the /hello webpage!");

        return "Hello,Application is running Username : " + username;
    }

    /*private final Student student ;
    private final Student student2;*/
   private final Teacher teacher;
   private final Principle principle;


    TestController(Teacher teacher, Principle principle)
    {
       /*this.student = student;
        this.student2 = student2;*/

        this.teacher = teacher;
        this.principle = principle;
       // System.out.println(student==student2);
    }




    @GetMapping("/study")
    public String  print()
    {
        return "study";
    }

    @GetMapping("/teach")
    public String testTeach()
    {
        return teacher.teach();
    }


}
