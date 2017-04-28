package com.example.core;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties properties;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();

        //DB 접속정보
        config.setDriverClassName(properties.getDriverClassName());
        config.setJdbcUrl(properties.getUrl());
        config.setUsername(properties.getUsername());
        config.setPassword(properties.getPassword());

        //pool의 이름을 정한다.
        config.setPoolName("Whydda-Demo-HikariCP-Pool");

        //pool 설정
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }

    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate  = new NamedParameterJdbcTemplate(dataSource());
        return namedParameterJdbcTemplate;
    }
}
