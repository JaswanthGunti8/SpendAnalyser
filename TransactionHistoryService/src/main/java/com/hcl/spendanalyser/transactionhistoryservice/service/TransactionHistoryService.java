package com.hcl.spendanalyser.transactionhistoryservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionsGrouped;
import com.hcl.spendanalyser.transactionhistoryservice.repository.TransactionHistoryRepository;

@Service
public class TransactionHistoryService {

	@Autowired
	TransactionHistoryRepository transactionRepository;

	public List<TransactionHistory> getAllTransactions(String customerId) {
		return transactionRepository.findAllByCustomerId(customerId);
	}

	public List<TransactionsGrouped> getTransactionsByMonth(String customerId, int noOfMonths) {
		List<TransactionsGrouped> tranList = new ArrayList<>();

		LocalDate currentDate = LocalDate.now();
		for (int i = 0; i < noOfMonths; i++) {
			LocalDate lastMonth = currentDate.minusMonths(i);

			int year = lastMonth.getYear();
			int month = lastMonth.getMonthValue();

			tranList.add(getTransactionsByMonthYear(year, month, customerId));
		}

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
