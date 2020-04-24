package com.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	   private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
	   private final JdbcTemplate jdbcTemplate;
	   
	   @Autowired
	   public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
	      this.jdbcTemplate = jdbcTemplate;
	   }
	   
	   public void afterJob(JobExecution jobExecution) { 
		   if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			   log.info("JOB FINISHED - please check results");
			   List<User> results = jdbcTemplate.query(
			            "SELECT first_name, last_name FROM USERS",
		                (rs, rowNum) -> new User(rs.getString("first_name"), rs.getString("last_name")));
			            
		   
		   
	       for (User person : results) {
	            log.info("Found <" + person + "> in the database.");
	         }
	      }
	   }
}
