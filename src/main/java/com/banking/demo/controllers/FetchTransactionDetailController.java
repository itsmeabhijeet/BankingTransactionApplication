/**
 * 
 */
package com.banking.demo.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.model.TransactionDetail;
import com.banking.demo.service.IdataBaseService;

/**
 * @author Abhijeet Gupta
 *
 */
@RestController
public class FetchTransactionDetailController {

	@Autowired
	@Qualifier("MySQLDataBaseService")
	IdataBaseService serviceImpl;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping("/transactionDetails")
	public List<TransactionDetail> getTransactionDetails(@RequestParam int accountNumber) {

		List<TransactionDetail> listOfTransactions = serviceImpl.getListOfTransactions(accountNumber);

		return listOfTransactions;

	}

}
