package com.banking.demo.model;

import java.io.Serializable;

/**
 * @author Abhijeet Gupta
 *
 */
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Account fromAccount;
	private Account toAccount;
	private double amount;
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
