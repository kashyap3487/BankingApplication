package com.bank.model;

public class transaction {
	private Integer transactionId;
	private String fromAccount;
	private String toAccount;
	private String type;
	private Double amount;
	private String dateTime;
	
	public transaction(Integer transactionId, String fromAccount, String toAccount, String type, Double amount,
			String dateTime) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.type = type;
		this.amount = amount;
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "transaction [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", type=" + type + ", amount=" + amount + ", dateTime=" + dateTime + "]";
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
