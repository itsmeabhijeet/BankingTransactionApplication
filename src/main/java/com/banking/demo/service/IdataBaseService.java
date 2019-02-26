/**
 * 
 */
package com.banking.demo.service;

import java.util.List;

import com.banking.demo.model.TransactionDetail;

/**
 * @author Abhijeet Gupta
 *
 */
public interface IdataBaseService {

	public boolean transfer(int fromAccontNumber, int toAccountNumber, double amount);

	public List<TransactionDetail> getListOfTransactions(int accountNumber);

}
