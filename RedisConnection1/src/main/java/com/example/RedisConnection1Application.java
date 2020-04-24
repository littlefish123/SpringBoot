package com.example;

/*
 * 1) Install Ubuntu on Window 10
 * 2) Install Redis on Ubuntu
 * 3) Test redis-cli
 * 4) Write below programs and process with Redis by creating RedisTemplate bean(s)
https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-redis-example/
https://www.baeldung.com/spring-classpath-file-access
*/

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.Person.Gender;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class RedisConnection1Application {


	public static void main(String[] args) {
		/* test using AppllicationContext or ClassPathXmlApplicationContext */
		
		ApplicationContext applicationContext = SpringApplication.run(RedisConnection1Application.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}

	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	    							new ClassPathResource("classpath:applicationContext.xml").getPath());
//	    PersonRepo personRepo = (PersonRepo)applicationContext.getBean("personRepo");
	    PersonRepo personRepo = (PersonRepo)context.getBean("personRepo");
	 
	    Person person = new Person();
        person.setId("1");
        person.setAge(55);
        person.setGender(Gender.Male);
        person.setFirstname("Oracle");
        person.setLastname("Selina");
        
        personRepo.save(person);
        
        Person person2 = new Person();
        person2.setId("2");
        person2.setAge(60);
        person2.setGender(Gender.Male);
        person2.setFirstname("TheArchitect");
        person2.setLastname("Richard");
         
        personRepo.save(person2);
         
        Person person3 = new Person();
        person3.setId("3");
        person3.setAge(25);
        person3.setGender(Gender.Male);
        person3.setFirstname("TheOne");
        person3.setLastname("Timothy");
         
        personRepo.save(person3);
        
        System.out.println("Finding the One : "+personRepo.find("3"));
        
        Map <Object,Object> personMatrixMap = personRepo.findAll();
        
        System.out.println("Currently in the Redis Matrix");
     
        System.out.println(personMatrixMap);
        
        System.out.println("Deleting The Architect ");
        
        personRepo.delete("2");
         
        personMatrixMap = personRepo.findAll();
         
        System.out.println("Remnants .. : ");
         
        System.out.println(personMatrixMap);
         
        context.close();
			
	}
	

	

}
