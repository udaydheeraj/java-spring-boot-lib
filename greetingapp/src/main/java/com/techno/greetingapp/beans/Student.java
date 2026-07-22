package com.techno.greetingapp.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student {

    Book book;
    Pen pen;
    Bag bag;


    Student(Book book, Pen pen, Bag bag)
    {
        this.book = book;
        this.pen = pen;
        this.bag = bag;
        /*book.open();
        pen.write();
        bag.open();*/
        System.out.println("Student created");

    }

    @PostConstruct
    public void study()
    {
        System.out.println("Bean is studying");
    }
    @PreDestroy
    public void destroy()
    {
        System.out.println("Bean is destroyed");
    }

}
