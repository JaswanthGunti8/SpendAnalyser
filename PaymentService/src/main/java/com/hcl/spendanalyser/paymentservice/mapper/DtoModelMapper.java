package com.hcl.spendanalyser.paymentservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.spendanalyser.paymentservice.dto.PaymentDto;
import com.hcl.spendanalyser.paymentservice.model.Payment;

@Component
public class DtoModelMapper {
	
	@Autowired
	private Payment payment;
	
	
	public Payment paymentDtoToPaymentModel(PaymentDto paymentDto) {
		payment.setAmount(paymentDto.getAmount());
		payment.setCategory(paymentDto.getCategory());
		payment.setCustomerId(paymentDto.getCustomerId());
		payment.setPaymentType(paymentDto.getPaymentType());
		payment.setTranDesc(paymentDto.getTranDesc());
		
		return payment;
	}
}
