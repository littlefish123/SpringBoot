package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/* this program does not work 
 * https://www.tutorialspoint.com/spring_boot/spring_boot_tracing_micro_service_logs.htm
 * Instead, download zipkin server to ~zipkinserver/zipkinserver
 * java -jar zipkin-server-2.21.1-exec.jar
 * http://localhost:9411/
 */


@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}
