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
	// In real world it will be alphanumeric hence string.
	private int accountNumber;
	private String userName;
	private double balance;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
