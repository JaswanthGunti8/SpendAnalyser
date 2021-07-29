package com.hcl.spendanalyser.paymentservice.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.repository.PaymentRepository;
import com.hcl.spendanalyser.paymentservice.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public String addTransaction(Payment payment) {
		payment.setTranDate(LocalDateTime.now());
		paymentRepository.save(payment);
		return "Record Added Successfully";
	}

}
