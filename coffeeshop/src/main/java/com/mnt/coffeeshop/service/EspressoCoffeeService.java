package com.mnt.coffeeshop.service;

import com.mnt.coffeeshop.serviceinterface.CoffeeService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class EspressoCoffeeService implements CoffeeService {

    @PostConstruct
    public void startMachine()
    {
        System.out.println("Espresso: machine Started");
    }

    @Override
    public String prepareCoffee() {
        return "Preparing Espresso Coffee ☕";
    }

    @PreDestroy
    public void cleanMachine()
    {
        System.out.println("Espresso: cleaning machine");
    }
}
