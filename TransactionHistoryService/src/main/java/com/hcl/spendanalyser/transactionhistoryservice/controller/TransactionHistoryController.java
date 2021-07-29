package com.hcl.spendanalyser.transactionhistoryservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.spendanalyser.transactionhistoryservice.dto.TransactionAggregatedDto;
import com.hcl.spendanalyser.transactionhistoryservice.dto.TransactionListDto;
import com.hcl.spendanalyser.transactionhistoryservice.exception.DtoException;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionsGrouped;
import com.hcl.spendanalyser.transactionhistoryservice.service.TransactionHistoryService;

@RestController
public class TransactionHistoryController {

	@Autowired
	TransactionHistoryService transactionHistoryService;

	@GetMapping("/transactionlist")
	public ResponseEntity<List<TransactionHistory>> getAllTransactions(@RequestBody @Valid TransactionListDto transactionListDto,Errors errors) throws DtoException {
		if(errors.hasErrors()) {
			throw new DtoException(errors);
		}
		return new ResponseEntity<>(transactionHistoryService.getAllTransactions(transactionListDto.getCustomerId()),
				HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/transactionaggregated")
	public ResponseEntity<List<TransactionsGrouped>> getAllTransactionsGrouped(@RequestBody @Valid TransactionAggregatedDto transactionAggregatedDto,Errors errors) throws DtoException {
		if(errors.hasErrors()) {
			throw new DtoException(errors);
		}
		return new ResponseEntity<>(transactionHistoryService.getTransactionsByMonth(transactionAggregatedDto.getCustomerId(),transactionAggregatedDto.getNoOfMonths()),
				HttpStatus.ACCEPTED);
	}

}
