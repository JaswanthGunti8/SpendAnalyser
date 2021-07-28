package com.hcl.spendanalyser.transactionhistoryservice.model;

import java.util.List;


public class TransactionsGrouped {
	private String monthYear;
	private List<TransactionHistory> tranList;
	
	public TransactionsGrouped() {
	}
	
	public TransactionsGrouped(String monthYear, List<TransactionHistory> tranList) {
		this.monthYear = monthYear;
		this.tranList = tranList;
	}
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public List<TransactionHistory> getTranList() {
		return tranList;
	}
	public void setTranList(List<TransactionHistory> tranList) {
		this.tranList = tranList;
	}
	@Override
	public String toString() {
		return this.monthYear + ", " + tranList.toString();
	}
	
	
}
