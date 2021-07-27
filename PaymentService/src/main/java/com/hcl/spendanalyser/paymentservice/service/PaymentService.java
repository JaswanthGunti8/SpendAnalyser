package com.hcl.spendanalyser.paymentservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	
	public String addTransaction(Payment payment) {
		paymentRepository.save(payment);
		return "Record Added Successfully";
	}

}
