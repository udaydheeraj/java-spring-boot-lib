package com.mnt.coffeeshop.config;

import com.mnt.coffeeshop.external.PremiumCoffeeMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeConfig {

    @Bean
    public PremiumCoffeeMachine premiumCoffeeMachine()
    {
        return new PremiumCoffeeMachine();
    }
}
