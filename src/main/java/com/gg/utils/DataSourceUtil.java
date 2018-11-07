package com.gg.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceUtil {
    @Bean(name = "oracleDS")
    @Qualifier("oracleDS")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DruidDataSource primaryDataSource() {

        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "oracleJT")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("oracleDS") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "mysqlDS")
    @Qualifier("mysqlDS")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DruidDataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "mysqlJT")
    public JdbcTemplate mysqlJdbcTemplate(
            @Qualifier("mysqlDS") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
