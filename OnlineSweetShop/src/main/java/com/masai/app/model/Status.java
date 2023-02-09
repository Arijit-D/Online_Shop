package com.masai.app.model;

public enum Status {

	
	 ACTIVE("active"),
	    INACTIVE("inactive");

	    private final String value;

	    private Status (String value){

	        this.value=value;
	    }

	
}
