package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

	@Autowired 
	private JdbcTemplate	jdbcTemplate;
	
	public List<Customer> findAll() {
		 List<Customer> result = jdbcTemplate.query(
	                "SELECT id, name, email, created_date FROM customer",
	                (rs, rowNum) -> new Customer(rs.getInt("id"),
	                        rs.getString("name"), rs.getString("email"), rs.getDate("created_date"))
	        );
		 
		 return result;
	}
	
	public String getEmail(String name) {
		String query = "SELECT email, created_date FROM customer where name = " + name;
		String email = jdbcTemplate.query(
                query,
                (rs, rowNum) -> new Customer(rs.getInt("id"),
                        rs.getString("name"), rs.getString("email"), rs.getDate("created_date"))
        );
	 
	 return result;
	}
}
