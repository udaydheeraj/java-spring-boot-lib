package com.example.multidb.employee.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;

//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multidb.employee.repository",
        entityManagerFactoryRef = "employeeEntityManagerFactory",
        transactionManagerRef = "employeeTransactionManager")
public class EmployeeDbConfig {

    @Bean(name = "spring.datasource.employee")
    public DataSource dataSource()
    {
        return DataSourceBuilder
                .create().build();
    }

    @Bean(name = "employeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder, DataSource dataSource)

    {
        return builder
                .dataSource(dataSource)
                .packages("com.example.employee.entity")
                .persistenceUnit("employee")
                .build();
    }


    @Bean(name = "employeeTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("employeeEntityManagerFactory") EntityManagerFactory entityManagerFactory)
    {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
