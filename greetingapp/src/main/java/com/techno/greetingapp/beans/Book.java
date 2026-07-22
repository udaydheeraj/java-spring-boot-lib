package com.techno.greetingapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {



    public void open()
    {
        System.out.println("book opened");
    }
}
