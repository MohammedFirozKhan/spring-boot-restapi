package com.cisco.sp.springbootstarter.bank;

public class Account {
	
	private String userId;
	private String label;
	private String type;
	private String branchId;
	private Balance balance;
	private AccountRouting accountRouting;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public Balance getBalance() {
		return balance;
	}
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	public AccountRouting getAccountRouting() {
		return accountRouting;
	}
	public void setAccountRouting(AccountRouting accountRouting) {
		this.accountRouting = accountRouting;
	}

	
	

}
