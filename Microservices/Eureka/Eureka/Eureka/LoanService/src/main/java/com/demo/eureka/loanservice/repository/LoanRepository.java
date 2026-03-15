package com.demo.eureka.loanservice.repository;

import com.demo.eureka.loanservice.entity.Loan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
