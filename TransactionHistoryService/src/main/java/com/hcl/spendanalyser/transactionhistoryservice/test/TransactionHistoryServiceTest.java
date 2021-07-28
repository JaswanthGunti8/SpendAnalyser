package com.hcl.spendanalyser.transactionhistoryservice.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionsGrouped;
import com.hcl.spendanalyser.transactionhistoryservice.repository.TransactionHistoryRepository;
import com.hcl.spendanalyser.transactionhistoryservice.service.TransactionHistoryService;

@ExtendWith(SpringExtension.class)
@Import(TransactionHistoryService.class)
public class TransactionHistoryServiceTest {
	
	@MockBean
	private TransactionHistoryRepository transactionRepository;
	
	@Autowired
	TransactionHistoryService transactionHistoryService;
	
	@Test
	public void getAllTransactionsTest() {
		Mockito.when(transactionRepository.findAllByCustomerId(any(String.class))).thenReturn(new ArrayList<TransactionHistory>());
		
		assertEquals(new ArrayList<TransactionHistory>(), transactionHistoryService.getAllTransactions("12456789"));
		
		Mockito.verify(transactionRepository).findAllByCustomerId(any(String.class));
	}
	
	@Test
	public void getAllTransactionsByMonthTest() {
		Mockito.when(transactionRepository.findByTranDateMatches(any(Integer.class),any(Integer.class),any(String.class))).thenReturn(new ArrayList<TransactionHistory>());
		List<TransactionsGrouped> list = new ArrayList<TransactionsGrouped>();
		list.add(new TransactionsGrouped("2021-07",new ArrayList<TransactionHistory>()));
		
		assertEquals(list.toString(), transactionHistoryService.getTransactionsByMonth("12456789",1).toString());
		
		Mockito.verify(transactionRepository).findByTranDateMatches(any(Integer.class),any(Integer.class),any(String.class));
	}
}
