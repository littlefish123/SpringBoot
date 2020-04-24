package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {
	/*
	   @Bean(name = "dbCustomerService")
	   @ConfigurationProperties(prefix = "spring.dbCustomerService")
	   @Primary
	   public DataSource createCustomerServiceDataSource() {
	      return DataSourceBuilder.create().build();
	   }
	
   
	   @Bean(name = "jdbcCustomerService")
	   @Autowired
	   public JdbcTemplate createJdbcTemplate_CustomerService(@Qualifier("dbCustomerService") DataSource customerServiceDS) {
	      return new JdbcTemplate(customerServiceDS);
	   }
	   */
	  /*
	   @Bean(name = "CustomerRepository")
	   public CustomerRepository createCustomerRepository() {
		   return new CustomerRepository();
	   }
	*/
}
