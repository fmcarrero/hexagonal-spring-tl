package com.ceiba.demo.infrastructure.application.springapp.config;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

	
	private HttpStatus status;

    
	private String message;

	private int code;

	public ApiError(HttpStatus status, String message, int code) {
		this.status = status;
		this.message = message;
		this.code = code;
	}


	public int getCode() {
		return this.code;
	}
	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return this.message;
	}
}