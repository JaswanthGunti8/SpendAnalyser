package com.hcl.spendanalyser.paymentservice.model;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="TRANSACTIONS")
@Component
public class Payment {
	@Id
	private ObjectId id;
	private String customerId;
	private String tranDesc;
	private Double amount;
	private String category;
	private String paymentType;
	private LocalDateTime tranDate;
	
	public Payment() {
	}
	
	public Payment(String customerId, String tranDesc, Double amount, String category, String paymentType) {
		this.customerId = customerId;
		this.tranDesc = tranDesc;
		this.amount = amount;
		this.category = category;
		this.paymentType = paymentType;
	}
	
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
	public LocalDateTime getTranDate() {
		return tranDate;
	}
	public void setTranDate(LocalDateTime tranDate) {
		this.tranDate = tranDate;
	}
}
