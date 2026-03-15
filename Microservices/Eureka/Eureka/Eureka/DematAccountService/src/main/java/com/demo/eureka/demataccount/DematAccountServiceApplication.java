package com.demo.eureka.demataccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DematAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DematAccountServiceApplication.class, args);
		System.out.println("Demat account server started....");
	}

}
