package com.bank.model;

import java.util.List;

public class User {
	private Integer userId;
	private String password;
	private String firstName;
	private String lastName;
	private Integer contactNumber;
	private String email;
	private String address;
	private Boolean isApproved;
	private String varificationId;
	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getVarificationId() {
		return varificationId;
	}



	public User(Integer userId, String password, String firstName, String lastName, Integer contactNumber, String email,
			String address, Boolean isApproved,String varificationId) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.isApproved = isApproved;
		this.varificationId = varificationId;
//		this.accounts = accounts;
	}

	public void setVarificationId(String varificationId) {
		this.varificationId = varificationId;
	}
	
	
	
	
	
	public User( String password, String firstName, String lastName, Integer contactNumber, String email,
			String address,Boolean isApproved,String varificationId) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.isApproved = isApproved;
		this.varificationId = varificationId;
	}
	
	

	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}
//	private List<Account> accounts;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address
				+ ", varificationId=" + varificationId +  "]";
	}
	
	

}
