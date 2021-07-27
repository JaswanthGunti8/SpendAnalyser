package com.hcl.spendanalyser.paymentservice.controller;


import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.hcl.spendanalyser.paymentservice.model.Payment;
import com.hcl.spendanalyser.paymentservice.model.RequestErrors;
import com.hcl.spendanalyser.paymentservice.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	RequestErrors requestErrors;
	
	@PostMapping("/addpayment")
	public ResponseEntity<Object> recordPayment(@RequestBody @Valid Payment payment,Errors errors){
		if(errors.hasErrors()) {
			Map<String,String> errorMap = errors.getFieldErrors().
					stream().
					collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage,(s,a) -> s+", "+a));
			requestErrors.setErrors(errorMap);
			return new ResponseEntity<Object>(requestErrors,HttpStatus.BAD_REQUEST);
		}
		String result = paymentService.addTransaction(payment); 
		return new ResponseEntity<Object>(result,HttpStatus.ACCEPTED);
	}
}
