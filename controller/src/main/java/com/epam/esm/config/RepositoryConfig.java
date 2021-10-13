package com.epam.esm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@PropertySource(value = "classpath:application.properties")
@ComponentScan("com.epam.esm.*")
public class RepositoryConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public RepositoryConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${dataSource.user}")
    private String userName;
    @Value("${dataSource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}

