package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

/*
@RestController
@RefreshScope
public class ZinkinController {
	
	private static final Logger LOG = Logger.getLogger(ZinkinController.class.getName());	
	
	@Value("${welcome.message}")
	   String welcomeText;

	@RequestMapping(value = "/message")
	   public String welcomeText() {
		   LOG.info("message request is calling");
	      return welcomeText;
	   }	

	
	@Bean
	public  AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}	
}
*/