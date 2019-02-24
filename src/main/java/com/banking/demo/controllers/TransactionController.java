/**
 * 
 */
package com.banking.demo.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.model.Transaction;
import com.banking.demo.service.IdataBaseService;
import com.banking.demo.service.DataBaseServiceImpl;

/**
 * @author Abhijeet Gupta
 *
 */
@RestController
public class TransactionController {

	@Autowired
	@Qualifier("MySQLDataBaseService")
	IdataBaseService serviceImpl;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping("/transactions")
	public ResponseEntity<String> doTransaction(@RequestBody Transaction transaction) {
		ResponseEntity<String> responseEntity = null;
		boolean res = serviceImpl.transfer(transaction.getFromAccountNumber(), transaction.getToAccountNumber(),
				transaction.getAmount());
		if (res)
			responseEntity = new ResponseEntity<>("Transaction Success", HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<>("Transaction Failed", HttpStatus.BAD_REQUEST);
		return responseEntity;

	}

}
