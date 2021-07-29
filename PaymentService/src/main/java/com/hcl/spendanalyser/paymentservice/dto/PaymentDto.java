package com.hcl.spendanalyser.paymentservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class PaymentDto {

	@NotBlank(message = "Customer Id cannot be blank")
	private String customerId;
	@NotBlank(message = "Transaction Description cannot be blank")
	private String tranDesc;
	@Min(value = 0, message = "Transaction Amount should be greater than 0")
	private Double amount;
	@Pattern(regexp = "House|Income Source|Groceries", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Valid Categories are House, Income Source, Groceries")
	private String category;
	@Pattern(regexp = "Credit|Debit", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Payment Type can be credit or debit only")
	private String paymentType;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTranDesc() {
		return tranDesc;
	}

	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
