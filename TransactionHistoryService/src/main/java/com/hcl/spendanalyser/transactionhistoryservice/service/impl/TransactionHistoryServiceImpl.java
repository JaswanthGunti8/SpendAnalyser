package com.hcl.spendanalyser.transactionhistoryservice.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionsGrouped;
import com.hcl.spendanalyser.transactionhistoryservice.repository.TransactionHistoryRepository;
import com.hcl.spendanalyser.transactionhistoryservice.service.TransactionHistoryService;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService{

	private static final Logger LOGGER=LoggerFactory.getLogger(TransactionHistoryServiceImpl.class);
	
	@Autowired
	TransactionHistoryRepository transactionRepository;

	public List<TransactionHistory> getAllTransactions(String customerId) {
		LOGGER.info("In Get all Transactions: customer Id: {} ",customerId);
		return transactionRepository.findAllByCustomerId(customerId);
	}

	public List<TransactionsGrouped> getTransactionsByMonth(String customerId, int noOfMonths) {
		LOGGER.info("In Get all Transactions: customer Id: {} and No of months: {}",customerId,noOfMonths);
		List<TransactionsGrouped> tranList = new ArrayList<>();

		LocalDate currentDate = LocalDate.now();
		
		IntStream.range(0, noOfMonths).forEach((month) -> {
			LocalDate lastMonth = currentDate.minusMonths(month);
			tranList.add(getTransactionsByMonthYear(lastMonth.getYear(), lastMonth.getMonthValue(), customerId));
		});
		
		return tranList;
	}

	private TransactionsGrouped getTransactionsByMonthYear(int year, int month, String customerId) {
		TransactionsGrouped transactionsGrouped = new TransactionsGrouped();
		String yearmonth = year + "-" + String.format("%02d", month);
		transactionsGrouped.setMonthYear(yearmonth);
		transactionsGrouped.setTranList(transactionRepository.findByTranDateMatches(year, month, customerId));

		return transactionsGrouped;
	}
}
