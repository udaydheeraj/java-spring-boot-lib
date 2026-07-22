package com.mnt.coffeeshop.service;

import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    public String prepareCoffee()
    {
        return "Preparing Coffee...<br><br>Coffee Ready!";
    }
}
