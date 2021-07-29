package com.hcl.spendanalyser.paymentservice.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.repository.PaymentRepository;
import com.hcl.spendanalyser.paymentservice.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger LOGGER=LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public String addTransaction(Payment payment) {
		LOGGER.info("In Add Transaction {} ",payment);
		payment.setTranDate(LocalDateTime.now());
		paymentRepository.save(payment);
		return "Record Added Successfully";
	}

}
