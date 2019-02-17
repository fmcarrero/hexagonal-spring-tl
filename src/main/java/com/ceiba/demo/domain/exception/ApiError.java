package com.ceiba.demo.domain.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

	@JsonProperty("status")
	private HttpStatus status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("code")
	private int code;
	
	
	private List<String> errors;

	public ApiError(HttpStatus status, String message, String error, int code) {
		super();
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
		this.code =code;
	}

	public List<String> getErrors() {
		return new ArrayList<>(errors);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return this.message;
	}
}