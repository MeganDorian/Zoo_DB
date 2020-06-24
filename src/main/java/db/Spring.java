package db;

import db.services.CityService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@SpringBootApplication
//@ComponentScan("java")
public class Spring {
    final
    Environment properties;

    public Spring(Environment properties) {
        this.properties = properties;
    }

    public static String username;
    public static String password;

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUsername("postgres");
        dataSource.setPassword("castiel12345");
        dataSource.setUrl(properties.getProperty("spring.datasource.url"));
        return dataSource;
    }

}