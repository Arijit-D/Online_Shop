package com.masai.app.exception;



public class CustomerException extends RuntimeException{
	
	CustomerException(){
		
	}
	
	public CustomerException (String message) {
		
		super(message);
		
	}

}
