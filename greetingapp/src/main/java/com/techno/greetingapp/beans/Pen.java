package com.techno.greetingapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pen {


   public void write()
   {
       System.out.println("Pen Ready : use pen to write");

   }

}
