package com.hcl.spendanalyser.paymentservice.controlleradvice;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.spendanalyser.paymentservice.exception.DtoException;
import com.hcl.spendanalyser.paymentservice.model.RequestErrors;

@ControllerAdvice
public class ExceptionAdvice {
	
	@Autowired
	RequestErrors requestErrors;
	
	@ExceptionHandler(DtoException.class)
	public ResponseEntity<RequestErrors> mapException(DtoException dtoException){
		Map<String,String> errorMap = dtoException.getErrors().getFieldErrors().
				stream().
				collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage,(s,a) -> s+", "+a));
		requestErrors.setErrors(errorMap);
		
		return new ResponseEntity<>(requestErrors,HttpStatus.BAD_REQUEST);
		
	}
}
