package com.cbs.edu.springbootdemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
public class CbsDataSourceConfig {

    /*@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cbs");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }*/
}
