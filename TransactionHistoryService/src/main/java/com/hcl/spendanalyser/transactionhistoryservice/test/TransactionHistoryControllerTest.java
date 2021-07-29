package com.hcl.spendanalyser.transactionhistoryservice.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;

import com.hcl.spendanalyser.transactionhistoryservice.model.RequestErrors;
import com.hcl.spendanalyser.transactionhistoryservice.service.TransactionHistoryService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@Import(RequestErrors.class)
public class TransactionHistoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionHistoryService transactionHistoryService;

	@Test
	public void getAllTransactionTest() throws Exception {

		Mockito.when(transactionHistoryService.getAllTransactions(any(String.class)))
				.thenReturn(new ArrayList<>());

		RequestBuilder request = MockMvcRequestBuilders.get("/transactionlist")
				.contentType(MediaType.APPLICATION_JSON).content("{\"customerId\":\"123456789\"}");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isAccepted());
	}

	@Test
	public void getAllTransactionAggregateTest() throws Exception {

		Mockito.when(transactionHistoryService.getTransactionsByMonth(any(String.class), any(Integer.class)))
				.thenReturn(new ArrayList<>());

		RequestBuilder request = MockMvcRequestBuilders.get("/transactionaggregated").contentType(MediaType.APPLICATION_JSON)
				.content("{\"customerId\":\"123456789\",\"noOfMonths\":2}");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isAccepted());
	}

}
