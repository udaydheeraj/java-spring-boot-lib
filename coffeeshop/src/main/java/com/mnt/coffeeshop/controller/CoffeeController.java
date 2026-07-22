package com.mnt.coffeeshop.controller;

import com.mnt.coffeeshop.external.PremiumCoffeeMachine;
import com.mnt.coffeeshop.serviceinterface.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CoffeeController {


   // @Autowired
  //  @Qualifier("espressoCoffeeService")
    private  CoffeeService coffeeService;

    public CoffeeController(@Qualifier("espressoCoffeeService")
                            CoffeeService coffeeService)
    {
        this.coffeeService = coffeeService;
    }


    @Autowired
    @Lazy
    private PremiumCoffeeMachine premiumCoffeeMachine;

    @GetMapping("/order")
    @ResponseBody
    public String orderCoffee()
    {
        System.out.println("order coffee");
        return coffeeService.prepareCoffee();
    }

    @GetMapping("/premium")
    @ResponseBody
    public String orderPremiumCoffee()
    {
        System.out.println("Premium coffee order");
        return premiumCoffeeMachine.makePremiumCoffee();
    }
}
