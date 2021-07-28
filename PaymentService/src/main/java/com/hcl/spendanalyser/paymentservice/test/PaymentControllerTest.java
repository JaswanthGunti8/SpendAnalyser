package com.hcl.spendanalyser.paymentservice.test;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.model.RequestErrors;
import com.hcl.spendanalyser.paymentservice.service.PaymentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentService paymentService;

	@MockBean
	private RequestErrors requestErrors;
	
	@Test
	public void recordPaymentTest() throws Exception {

		Mockito.when(paymentService.addTransaction(any(Payment.class))).thenReturn("Record Added Successfully");

		RequestBuilder request = MockMvcRequestBuilders.post("/payment/addpayment")
				.contentType(MediaType.APPLICATION_JSON).content(
						"{\"customerId\": \"123456789\",\"tranDesc\": \"Salary Added\",\"amount\": 45462,\"category\": \"Income Source\",\"paymentType\": \"Credit\",\"tranDate\": \"2021-07-27T10:40:00Z\"}");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isAccepted())
		.andExpect(MockMvcResultMatchers.content().string("Record Added Successfully"));

		Mockito.verify(paymentService).addTransaction(any(Payment.class));
	}

}
