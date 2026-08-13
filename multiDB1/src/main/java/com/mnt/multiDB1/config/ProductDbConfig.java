package com.mnt.multiDB1.config;

import com.mnt.multiDB1.repository.ProductRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.TransactionManager;
import lombok.Data;
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
        basePackages = "com.mnt.multiDB1.repository",
        entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager"
)
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

    @Bean(name = "productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            @Qualifier("productDataSource") DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.mnt.multiDB1.entity");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPersistenceUnitName("product");

        Map<String, Object> properties = new HashMap<>();

        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);

        factory.setJpaPropertyMap(properties);

        return factory;
    }

    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("productEntityManagerFactory")
            EntityManagerFactory entityManagerFactory)
    {
        return new JpaTransactionManager(entityManagerFactory);

    }

}
