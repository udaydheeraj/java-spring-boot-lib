package com.mnt.coffeeshop.service;

import com.mnt.coffeeshop.serviceinterface.CoffeeService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class EspressoCoffeeService implements CoffeeService {

    @Value("${coffee.shop.name}")
    private String shopName;

    @Value("${coffee.espresso.price}")
    private int price;

    @PostConstruct
    public void startMachine()
    {
        System.out.println("Espresso: machine Started");
    }

    @Override
    public String prepareCoffee() {
        System.out.println("Prepare coffee: changes");
        return "Welcome to " + shopName +
        "<br><br>" +
                "Preparing Espresso Coffee ☕" +
                "<br><br>" +
                "Price : ₹" + price;
    }

    @PreDestroy
    public void cleanMachine()
    {
        System.out.println("Espresso: cleaning machine");
    }
}
