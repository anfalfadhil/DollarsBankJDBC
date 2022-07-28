package com.dollarsbank.exception;

import java.util.Date;

public class GlobalExceptionHandler extends Exception {
	private Date timestamp;
	private String message;
	private String details;
	
	public GlobalExceptionHandler(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public GlobalExceptionHandler(String message) {
		this.message= message;
		
	}
	
	

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
