package com.hcl.spendanalyser.transactionhistoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.spendanalyser.transactionhistoryservice.service.TransactionHistoryService;

@RestController
public class TransactionHistoryController {

	@Autowired
	TransactionHistoryService transactionHistoryService;

	@GetMapping("/transactionList/{customerId}")
	public ResponseEntity<Object> getAllTransactions(@PathVariable String customerId) {
		return new ResponseEntity<Object>(transactionHistoryService.getAllTransactions(customerId),
				HttpStatus.ACCEPTED);
	}

}
