package com.lse.spring.example.jta;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.*;

import javax.sql.DataSource;

@Profile("jdbc")
@Configuration
@PropertySources(
        @PropertySource("classpath:application.properties")
)
public class DaoConfigJdbc {
    @Value("${jdbc.driverClassName}")
    String dsDriverClassName;
    @Value("${jdbc.url}")
    String dsUrl;
    @Value("${jdbc.username}")
    String dsUsername;
    @Value("${jdbc.password}")
    String dsPassword;
    @Value("${jdbc.maxactive:10}")
    int dsMaxActive;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dsDriverClassName);
        dataSource.setUrl(dsUrl);
        dataSource.setUsername(dsUsername);
        dataSource.setPassword(dsPassword);
        dataSource.setMaxActive(dsMaxActive);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager ds = new DataSourceTransactionManager();
        ds.setDataSource(dataSource());
        return ds;
    }

   // @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer init = new DataSourceInitializer();
        init.setDataSource(dataSource());
        init.setEnabled(true);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);

        Resource createSchema = new ClassPathResource("db/createSchema.sql");
        Resource createTables = new ClassPathResource("db/createTables.sql");
        Resource loadTables = new ClassPathResource("db/loadTables.sql");

        populator.setScripts(createSchema, createTables, loadTables);
        init.setDatabasePopulator(populator);

        return init;
    }

}
