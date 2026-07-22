package com.mnt.coffeeshop.controller;

import com.mnt.coffeeshop.serviceinterface.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/order")
    @ResponseBody
    public String orderCoffee()
    {
        System.out.println("order coffee");
        return coffeeService.prepareCoffee();
    }
}
