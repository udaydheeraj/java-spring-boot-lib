package com.mnt.multiDB1.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomerDbConfig {

    @Bean(name = "customerDataSource")
    public DataSource customerDataSource()
    {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/customer_db")
                .username("root")
                .password("uday@2026")
                .driverClassName("com.mysql.cj.jdbc.Driver").build();
    }
}
