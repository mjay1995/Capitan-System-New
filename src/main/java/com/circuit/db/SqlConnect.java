<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Marvin
 */
@Configuration
@ComponentScan(basePackageClasses = DatabaseSource.class)
public class SqlConnect {
    
    
    @Bean(name="dataSource")
    public DataSource getDataSource()
    {
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("com.mysql.jdbc.Driver");
        dm.setUrl("jdbc:mysql:" + System.getProperty("DB_LOCATION"));
        return dm;
        
    }
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.db;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Marvin
 */
@Configuration
@ComponentScan(basePackageClasses = DatabaseSource.class)
public class SqlConnect {
    
    
    @Bean(name="dataSource")
    public DataSource getDataSource()
    {
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("org.sqlite.JDBC");
        dm.setUrl("jdbc:sqlite:" + System.getProperty("DB_LOCATION"));
        return dm;
        
    }
    
    
}
>>>>>>> 2ab93fcef3975e1f2819e3d73b99eb62239bf359
