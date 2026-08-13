package com.mnt.multiDB1.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProductDbConfig {

    @Bean(name = "productDataSource")
    public DataSource  productDataSource()
    {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/product_db")
                .username("root")
                .password("uday@2026")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

}
