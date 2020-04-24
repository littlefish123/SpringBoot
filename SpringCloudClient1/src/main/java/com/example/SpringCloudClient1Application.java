package com.example;

import org.springframework.beans.factory.annotation.Value;

/*
/*
https://www.tutorialspoint.com/spring_boot/spring_boot_cloud_configuration_client

bug : cannot refresh welcome.message after update config-client.properties in GITHUB

build docker image not work because cannot install Docker Enterprise wihtout Window 10 Pro
https://www.tutorialspoint.com/spring_boot/spring_boot_creating_docker_image.htm

1. Start Docker Terminal
2. copy ~/target/SpringCloudClient1*.jar ../src/main/docker
3. Create Dockerfile
4. Run "docker image build --tag springcloudclient:1.0 ."
5. 

*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;


@SpringBootApplication
@RefreshScope 
@RestController 
/* @EnableEurekaClient */
public class SpringCloudClient1Application {
	
	private static final Logger LOG =  Logger.getLogger(SpringCloudClient1Application.class.getName());
	
	public static void main(String[] args) {
		LOG.info("start apps");
		SpringApplication.run(SpringCloudClient1Application.class, args);
	}
	
	@Bean
	public  AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}	
	
	
	@Value("${welcome.message}")
	   String welcomeText;

	@RequestMapping(value = "/message")
	   public String welcomeText() {
		   LOG.info("message request is calling");
	      return welcomeText;
	   }	
}
