package com.demo.eureka.customerservice.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository custRep;
    @GetMapping("/{customerId}")
    public Customer getCustomers(@PathVariable int customerId) {
        return custRep.findById(customerId).get();
    }

}
