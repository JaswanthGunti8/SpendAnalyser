package com.hcl.spendanalyser.paymentservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.repository.PaymentRepository;
import com.hcl.spendanalyser.paymentservice.service.impl.PaymentServiceImpl;

@ExtendWith(SpringExtension.class)
@Import(PaymentServiceImpl.class)
public class PaymentServiceTest {

	@MockBean
	PaymentRepository paymentRepository;
	
	@Autowired
	PaymentServiceImpl paymentService;
	
	@Test
	public void addPaymentTest() {
		Payment payment = new Payment("123456789","Salary",754921.0,"Income Source","Credit");
		
		Mockito.when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
		
		assertEquals("Record Added Successfully", paymentService.addTransaction(payment));
		
		Mockito.verify(paymentRepository).save(any(Payment.class));
	}
}
