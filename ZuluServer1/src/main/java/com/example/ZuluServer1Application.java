package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuluServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuluServer1Application.class, args);
	}

}
