package com.masai.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> customerException(CustomerException se){
		
		return new ResponseEntity<String>(se.getMessage(),HttpStatus.BAD_GATEWAY);
		
	}
	
}
