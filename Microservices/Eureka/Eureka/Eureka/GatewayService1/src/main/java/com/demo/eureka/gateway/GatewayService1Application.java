package com.demo.eureka.gateway;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GatewayService1Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayService1Application.class, args);
		System.out.println("Gateway Server Stared!!");
	}

}
