package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actuator_Controller {
	@GetMapping("/path")
	public String returnHello() {
		return "Hello actuator!";
	}
}
