package com.hcl.spendanalyser.transactionhistoryservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class TransactionAggregatedDto {
	
	@NotBlank(message="Customer Id cannot be blank")
	private String customerId;
	@Min(value=1,message="No of Months should be should be greater than 0")
	private int noOfMonths;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getNoOfMonths() {
		return noOfMonths;
	}
	public void setNoOfMonths(int noOfMonths) {
		this.noOfMonths = noOfMonths;
	}
	
	
}
