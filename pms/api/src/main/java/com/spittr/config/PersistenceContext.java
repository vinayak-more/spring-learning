package com.spittr.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.spittr.web.repository.impl.jpa"})
public class PersistenceContext {
    @Autowired
    Environment env;

    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        System.out.println("driver class=" + env.getProperty("db.driver"));
        dataSourceConfig.setDriverClassName(env.getProperty("db.driver"));
        dataSourceConfig.setJdbcUrl(env.getProperty("db.url"));
        dataSourceConfig.setUsername(env.getProperty("db.username"));
        dataSourceConfig.setPassword(env.getProperty("db.password"));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.spittr.web.bean");

        Properties jpaProperties = new Properties();

        // Configures the used database dialect. This allows Hibernate to create SQL
        // that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

        // Specifies the action that is invoked to the database when the Hibernate
        // SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        // Configures the naming strategy that is used when Hibernate creates
        // new database objects and schema elements
        jpaProperties.put("hibernate.ejb.naming_strategy", env.getProperty("hibernate.ejb.naming_strategy"));

        // If the value of this property is true, Hibernate writes all SQL
        // statements to the console.
        jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        // If the value of this property is true, Hibernate will format the SQL
        // that is written to the console.
        jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
