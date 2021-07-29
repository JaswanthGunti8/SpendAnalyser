package com.hcl.spendanalyser.transactionhistoryservice.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class TransactionListDto {
	@NotBlank(message="Customer Id Cannot be blank")
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
