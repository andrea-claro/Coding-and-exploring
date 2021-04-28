package it.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.LibroDAO;
import dao.impl.LibroDAOImplDB;
import dao.impl.TypePersistence;
import factory.LibroFactory;
import it.dao.EmployeeDao;
import it.dao.imp.EmployeeDaoImpl;
import model.Libro;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
@ComponentScan({ "it.dao" })
public class SpringJDBCConfiguration {
	
    @Autowired
    private Environment environment;
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        //MySQL database we are using
        dataSource.setDriverClassName(environment.getRequiredProperty("driver"));
        dataSource.setUrl(environment.getRequiredProperty("url"));//change url
        dataSource.setUsername(environment.getRequiredProperty("user"));//change userid
        dataSource.setPassword(environment.getRequiredProperty("password"));//change pwd
        
        
        //H2 database
        
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    
    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate() {
    	NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return namedJdbcTemplate;
    }
    
    @Bean
    public LibroDAO libroDAO(){
    	LibroDAO ld = LibroFactory.getInstance(TypePersistence.DATABASE);
//        empDao.setJdbcTemplate(jdbcTemplate());
        return ld;
    }

}
