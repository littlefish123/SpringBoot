package com.example;

/*
https://www.tutorialspoint.com/spring_boot/spring_boot_cloud_configuration_server.htm
*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerApplication.class, args);
	}


	
}
