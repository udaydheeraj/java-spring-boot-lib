package com.techno.greetingapp.beans;

import org.springframework.stereotype.Component;

@Component
public class Teacher {

    Teacher()
    {
        System.out.println("Teacher Created");
    }

    public String teach()
    {
        return "Teacher is teaching";
    }
}
