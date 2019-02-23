/**
 * 
 */
package com.banking.demo.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.model.Transaction;

/**
 * @author Abhijeet Gupta
 *
 */
@RestController
public class TransactionController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping("/transactions")
	public ResponseEntity<String> doTransaction(@RequestBody Transaction transaction) {
		return null;

	}

}
