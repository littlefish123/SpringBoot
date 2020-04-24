package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* https://spring.io/guides/gs/batch-processing/ */
/* To enable work with Oracle instead of hsqldb, set property in the application.properties
 * spring.batch.initialize-schema=always*/

@SpringBootApplication
public class BatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchServiceApplication.class, args);
	}

}
