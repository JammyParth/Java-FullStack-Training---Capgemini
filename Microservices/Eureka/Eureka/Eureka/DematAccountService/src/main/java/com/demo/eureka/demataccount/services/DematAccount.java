package com.demo.eureka.demataccount.services;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DematAccount {

    @Id
    private int accountId;

    private Long customerId;
    private String brokerName;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
}