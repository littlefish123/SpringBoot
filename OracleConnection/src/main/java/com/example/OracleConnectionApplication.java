package com.example;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * http://zetcode.com/springboot/qualifier/
 * 
 * 3 methods to initialize beans 
 * 
 * Method 1
 * 1) applicationContext.xml under src & test/resources folder
 *    @ImportResource({"classpath*:applicationContext.xml"})  in the OracleConnectionApplication
 * 2) Autowired Person manager, student in OracleConnectionApplication
 * 3) No need add below annotation in Student and Manager class 
 *       @Component
 *     @Qualifier("manager")
 * 4) able to read default value from XML file
 *     
 *  Method 2
 * 1) Remove applicationContext.xml and  @ImportResource({"classpath*:applicationContext.xml"})  in the OracleConnectionApplication
 * 2) Add below annotation to Student and Manager variable under OracleConnectionApplication
 *   @Autowired
 *	 @Qualifier("manager")
 *	 static private Person p1;
 * 3) add below annotation in Student and Manager class
 *     @Component
 *     @Qualifier("manager")
 *     
 *  Method 3 - use PersonFactory
 *  1) Create PersonFactory
 *  2) Add @Component to Student and Manager class
 *  3) Remove @ImportResource({"classpath*:applicationContext.xml"}) under OracleConnectionApplication
 *  4) add below variable in the OracleConnectionApplication	
 *  @Autowired
	static private Person p1;

	@Autowired
	static private Person p2;
	
 
1) setup oracle 12 docker container
running Docker Toolbox -> terminal 
docker pull store/oracle/database-enterprise:12.2.0.1
https://hub.docker.com/u/littlefish123/content/sub-0340222b-a97a-4014-bed1-d92576ecbf79

2) docker run -d -it --name SelinaDB -P store/oracle/database-enterprise:12.2.0.1
3) docker port <Oracle-DB> 1521/tcp  -> get mapping port 0.0.0.0:32769

https://docs.docker.com/engine/install/ubuntu/
https://docs.docker.com/engine/install/linux-postinstall/


4) https://mkyong.com/spring-boot/spring-boot-jdbc-oracle-database-commons-dbcp2-example/

how-to-add-oracle-jdbc-driver-in-your-maven-local-repository
https://mkyong.com/maven/how-to-add-oracle-jdbc-driver-in-your-maven-local-repository/

connect-to-oracle-db-via-jdbc-driver-java
https://mkyong.com/jdbc/connect-to-oracle-db-via-jdbc-driver-java/

https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-sql

https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-database-initialization

https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html

dbcp 
https://commons.apache.org/proper/commons-dbcp/configuration.html
*/
	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;


@SpringBootApplication
//@ImportResource({"classpath*:applicationContext.xml"})    // use by Method 1
public class OracleConnectionApplication  {
	
	
	@Autowired
	static DataSource dataSource;
	
	@Autowired 
	static CustomerRepository customerRepository;
	
	/* Method 1 - use below code when using applicationContext.xml 
	@Autowired
	static Person p1;
	
	@Autowired
	static Person p2;
	*/
	
	/* Method 2 - Autowired but not use applicationContext.xml 
	@Autowired
	@Qualifier("manager")
	static private Person p1;
	
	@Autowired
	@Qualifier("student")
	static private Person p2;
	*/
	
	/* Method 3 - using PersonFactory */
	@Autowired
	static private Person p1;

	@Autowired
	static private Person p2;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(OracleConnectionApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		customerRepository = (CustomerRepository) applicationContext.getBean("customerRepository");
		
		System.out.println("Datasource = " + dataSource);
		
		System.out.println("Display all customers");
		
		List<Customer> list = customerRepository.findAll();
		list.forEach(x -> System.out.println(x));
		
		p1 = (Person) applicationContext.getBean("manager");
		p2 = (Person) applicationContext.getBean("student");
		System.out.printf("%s %s\n", p1.getInfo(), p1.getGender());
		System.out.printf("%s %s\n", p2.getInfo(), p2.getGender());
		
		System.out.printf("%s %s\n", p1.processInfo(), p1.processGender());
		System.out.printf("%s %s\n", p2.processInfo(), p2.processGender());

	}
	

}
