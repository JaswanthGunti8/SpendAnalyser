package com.hcl.spendanalyser.transactionhistoryservice.service;

import java.util.List;


import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionsGrouped;

public interface TransactionHistoryService {

	List<TransactionHistory> getAllTransactions(String customerId);
	List<TransactionsGrouped> getTransactionsByMonth(String customerId, int noOfMonths);
}
