package com.hcl.spendanalyser.transactionhistoryservice.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

public class DtoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private Errors errors;
	
	public DtoException(Errors errors) {
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	
	
}
