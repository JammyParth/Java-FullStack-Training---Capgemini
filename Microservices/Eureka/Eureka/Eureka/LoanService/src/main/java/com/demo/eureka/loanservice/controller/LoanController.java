package com.demo.eureka.loanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.eureka.loanservice.entity.Loan;
import com.demo.eureka.loanservice.repository.LoanRepository;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanRepository loanRep;
    @GetMapping("/{customerId}")
    public Loan getLoans(@PathVariable int customerId) {
        return loanRep.findById(customerId).get();
    }

}