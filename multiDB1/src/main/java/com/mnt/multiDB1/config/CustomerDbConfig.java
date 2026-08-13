package com.mnt.multiDB1.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.mnt.multiDB1.customer.repository",
        entityManagerFactoryRef = "customerEntityManagerFactory",
        transactionManagerRef = "customerTransactionManager"
)
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

    @Bean("customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            @Qualifier("customerDataSource") DataSource  dataSource) {
        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setDataSource(dataSource);

        factory.setPackagesToScan(
                "com.mnt.multiDB1.customer.entity"
        );

        factory.setJpaVendorAdapter(vendorAdapter);

        factory.setPersistenceUnitName("customer");

        Map<String, Object> properties = new HashMap<>();

        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);

        factory.setJpaPropertyMap(properties);

        return factory;
    }

    @Bean("customerTransactionManager")
    public PlatformTransactionManager  transactionManager(
            @Qualifier("customerEntityManagerFactory") EntityManagerFactory emf)
    {
        return new JpaTransactionManager(emf);
    }

}
