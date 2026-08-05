package com.example.multidb.customer.config;

import jakarta.persistence.EntityManagerFactory;
//import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multidb.customer.repository",
        entityManagerFactoryRef = "customerEntityManagerFactory",
        transactionManagerRef = "customerTransactionManager"
)
public class CustomerDbConfig {

    @Bean(name = "customerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.customer")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("customerDataSource") DataSource dataSource)
    {
        return builder
                .dataSource(dataSource)
                .packages("com.example.multidb.customer.entity")
                .persistenceUnit("customer")
                .build();
    }

    @Bean("customerTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("customerEntityManagerFactory")
                                                                     EntityManagerFactory entityManagerFactory)
    {
        return  new JpaTransactionManager(entityManagerFactory);

    }






}
