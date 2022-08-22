package com.bank.model;

public class Account {
	private Integer accountNumber;
	private Double amount;
	private String accountType;
	private Integer UserId;
	
	
	public Account(Integer userId) {
		super();
		UserId = userId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Account(Integer accountNumber, Double amount, String accountType, Integer userId) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.accountType = accountType;
		UserId = userId;
	}

	public Account(Integer accountNumber, Double amount, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.accountType = accountType;
	}
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + ", accountType=" + accountType + "]";
	}
	
	public boolean withdraw(double amt) {
		if (amt > this.amount) {
			return false;
		}else {
			this.amount = this.amount - amt;
			return true;
		}
		
	}
	
	public boolean deposit(double amt) {
		if (amt <= 0) {
			return false;
		}else {
			this.amount = this.amount + amt;
			return true;
		}
		
	}

}
