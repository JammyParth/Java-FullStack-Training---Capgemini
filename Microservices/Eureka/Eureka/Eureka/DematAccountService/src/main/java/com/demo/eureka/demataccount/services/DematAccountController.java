package com.demo.eureka.demataccount.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demataccounts")
public class DematAccountController {
	
	@Autowired
	private DematAccountRepository custRep;
    @GetMapping("/{accountId}")
    public DematAccount getLoans(@PathVariable int accountId) {
        return (DematAccount) custRep.findById(accountId).get();
    }

}
