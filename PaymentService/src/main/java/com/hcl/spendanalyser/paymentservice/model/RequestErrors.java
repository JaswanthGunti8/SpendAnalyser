package com.hcl.spendanalyser.paymentservice.model;

import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class RequestErrors {
	private Map<String,String> errors;

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
}
