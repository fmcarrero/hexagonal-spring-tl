package com.ceiba.demo.infrastructure.adapter.application.springapp.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.demo.domain.constants.CodeErrorConstants;
import com.ceiba.demo.domain.constants.ErrorConstants;
import com.ceiba.demo.domain.constants.PersonConstants;
import com.ceiba.demo.domain.exception.ApiError;
import com.ceiba.demo.domain.exception.NotFoundPersonException;



@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ErrorConstants.NUMBER_BAD_FORMAT, "",
				CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(NotFoundPersonException.class)
	protected ResponseEntity<Object> notFoundPersonException(NotFoundPersonException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, PersonConstants.NOT_FOUND_PERSON, "",
				CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> errorGeneric(Exception ex) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ErrorConstants.UNEXPECTED_ERROR, "",
				CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
