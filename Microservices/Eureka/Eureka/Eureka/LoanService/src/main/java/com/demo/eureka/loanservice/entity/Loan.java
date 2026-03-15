package com.demo.eureka.loanservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Loan {

    @Id
    private int loanId;
    private int customerId;
    private double loanAmount;
    private double interestRate;
   
    public Loan() {
    }

    public Loan(int loanId, int customerId, double loanAmount, String loanType, int tenure, double interestRate) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}