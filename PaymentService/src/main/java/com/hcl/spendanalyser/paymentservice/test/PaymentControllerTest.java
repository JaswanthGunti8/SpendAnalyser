package com.hcl.spendanalyser.paymentservice.test;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

import com.hcl.spendanalyser.paymentservice.mapper.DtoModelMapper;
import com.hcl.spendanalyser.paymentservice.model.RequestErrors;
import com.hcl.spendanalyser.paymentservice.service.impl.PaymentServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@Import({DtoModelMapper.class,RequestErrors.class})
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentServiceImpl paymentService;

	@MockBean
	private DtoModelMapper dtoModelMapper;
	
	
	@Test
	public void recordPaymentTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/payment/addpayment")
				.contentType(MediaType.APPLICATION_JSON).content(
						"{\"customerId\": \"123456789\",\"tranDesc\": \"Salary Added\",\"amount\": 45462,\"category\": \"Income Source\",\"paymentType\": \"Credit\"}");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());

	}

}
