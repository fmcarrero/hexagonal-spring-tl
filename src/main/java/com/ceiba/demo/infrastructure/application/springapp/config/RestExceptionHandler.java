package com.ceiba.demo.infrastructure.application.springapp.config;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.demo.domain.constants.CodeErrorConstants;
import com.ceiba.demo.domain.constants.ErrorConstants;
import com.ceiba.demo.domain.exception.InvalidDataPersonException;
import com.ceiba.demo.domain.exception.NotFoundPersonException;

@Order()
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(NotFoundPersonException.class)
	protected ResponseEntity<Object> notFoundPersonException(NotFoundPersonException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	
	@ExceptionHandler(InvalidDataPersonException.class)
	protected ResponseEntity<Object> invalidDataPersonException(InvalidDataPersonException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(),
				CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> errorGeneric(Exception ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ErrorConstants.UNEXPECTED_ERROR,
				CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
