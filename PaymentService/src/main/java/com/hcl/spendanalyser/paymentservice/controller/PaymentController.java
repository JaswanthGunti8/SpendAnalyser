package com.hcl.spendanalyser.paymentservice.controller;


import javax.validation.Valid;

import com.hcl.spendanalyser.paymentservice.dto.PaymentDto;
import com.hcl.spendanalyser.paymentservice.exception.DtoException;
import com.hcl.spendanalyser.paymentservice.mapper.DtoModelMapper;
import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.service.impl.PaymentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentServiceImpl paymentService;
	
	@Autowired
	DtoModelMapper dtoModelMapper;
	
	@PostMapping("/addpayment")
	public ResponseEntity<String> recordPayment(@RequestBody @Valid PaymentDto paymentDto,Errors errors) throws DtoException{
		if(errors.hasErrors()) {
			throw new DtoException(errors);
		}
		Payment payment = dtoModelMapper.paymentDtoToPaymentModel(paymentDto);
		String result = paymentService.addTransaction(payment); 
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
}
