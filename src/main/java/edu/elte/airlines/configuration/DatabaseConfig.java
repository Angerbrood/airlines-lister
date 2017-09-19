package edu.elte.airlines.configuration;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
@Import({ DatabasePropertiesNormalConfig.class, DatabasePropertiesCreateConfig.class })
public class DatabaseConfig {

    private static Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Autowired
    private DatabaseProperties databaseProperties;

    @Bean
    DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(databaseProperties.getDriverClassName());
        dataSource.setUrl(databaseProperties.getUrl());
        dataSource.setUsername(databaseProperties.getUsername());
        dataSource.setPassword(databaseProperties.getPassword());
        return dataSource;
    }

    @Bean
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        //factoryBean.setPackagesToScan("hu.elte.cinema.model");
        factoryBean.setDataSource(dataSource());
        factoryBean.setAnnotatedClasses();
        Properties hibernateProperties = hibernateProperties();
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }

    @Autowired
    @Bean
    HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }


    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.format_sql", databaseProperties.getShowSql());
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", databaseProperties.getHbm2ddlAuto());
        logger.info("Database properties: {}", hibernateProperties);
        return hibernateProperties;
    }
}
