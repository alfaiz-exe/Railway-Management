package com.example.demo.dataSource;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//this annotation tells spring boot that it is the configuration spring should process
public class PostgresDatasource
{
    @Bean
    //it tells the spring to make an object returned
    // by this method and put it into the spring application context
    @ConfigurationProperties("app.datasource")
    //it takes data from application.properties
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
    //this is a function that returns HikariDataSource Object
    //HikariDataSource is a java object provided by HikariCP
    //a high performance JDBC connection pool
    //it does not create a new database connection every time
    //Hikari keeps a pool of reusable connection
}
