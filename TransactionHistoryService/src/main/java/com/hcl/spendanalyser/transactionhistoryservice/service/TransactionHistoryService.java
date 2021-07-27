package com.hcl.spendanalyser.transactionhistoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.repository.TransactionHistoryRepository;

@Service
public class TransactionHistoryService {

	@Autowired
	TransactionHistoryRepository transactionRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	public List<TransactionHistory> getAllTransactions(String customerId) {
		return transactionRepository.findAllByCustomerId(customerId);
	}

	
}
