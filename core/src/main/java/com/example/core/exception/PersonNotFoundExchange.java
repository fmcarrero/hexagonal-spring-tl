package com.example.core.exception;

public class PersonNotFoundExchange extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public PersonNotFoundExchange(String message) {
	     super(message);
	}
}
