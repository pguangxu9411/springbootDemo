package com.gg.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceUtil {
    @Bean(name = "oracleDS")
    @Qualifier("oracleDS")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "oracleJT")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("oracleDS") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "mysqlDS")
    @Qualifier("mysqlDS")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "mysqlJT")
    public JdbcTemplate mysqlJdbcTemplate(
            @Qualifier("mysqlDS") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
