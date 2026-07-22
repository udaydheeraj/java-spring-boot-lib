package com.mnt.coffeeshop.service;

import com.mnt.coffeeshop.serviceinterface.CoffeeService;
import org.springframework.stereotype.Service;

@Service
public class FilterCoffeeService implements CoffeeService {
    @Override
    public String prepareCoffee() {
        return "FilterCoffee : Preparing coffee";
    }
}
