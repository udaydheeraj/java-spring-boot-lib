package com.mnt.coffeeshop.config;

import com.mnt.coffeeshop.external.PremiumCoffeeMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class CoffeeConfig {

    @Bean
    @Lazy
    public PremiumCoffeeMachine premiumCoffeeMachine()
    {
        return new PremiumCoffeeMachine();
    }
}
