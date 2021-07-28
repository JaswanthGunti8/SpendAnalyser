package com.hcl.spendanalyser.transactionhistoryservice.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionHistory;
import com.hcl.spendanalyser.transactionhistoryservice.model.TransactionsGrouped;
import com.hcl.spendanalyser.transactionhistoryservice.service.TransactionHistoryService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TransactionHistoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionHistoryService transactionHistoryService;

	@Test
	public void getAllTransactionTest() throws Exception {

		Mockito.when(transactionHistoryService.getAllTransactions("123456789"))
				.thenReturn(new ArrayList<TransactionHistory>());

		RequestBuilder request = MockMvcRequestBuilders.get("/transactionList/123456789");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.content().json("[]"));
	}

	@Test
	public void getAllTransactionAggregateTest() throws Exception {

		Mockito.when(transactionHistoryService.getTransactionsByMonth("123456789", 1))
				.thenReturn(new ArrayList<TransactionsGrouped>());

		RequestBuilder request = MockMvcRequestBuilders.get("/transactionaggregated/123456789/1");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.content().json("[]"));
	}

}
