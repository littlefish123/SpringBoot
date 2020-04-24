package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* use for method 3 */
@Configuration
public class PersonFactory {

	@Bean
	@Qualifier("student")
	public Person createStudent() {
		return new Student();
	}

	@Bean
	@Qualifier("manager")
	public Person createManager() {
	return new Manager();
}

}
