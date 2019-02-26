/**
 * 
 */
package com.banking.demo.model;

/**
 * @author Abhijeet Gupta
 *
 */
public class Account {
	
	// for simplicity kept account number int. 
	// In real world it will be alphanumeric that is string.
	private int accountID;
	private String name;;
	private double balance;
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
