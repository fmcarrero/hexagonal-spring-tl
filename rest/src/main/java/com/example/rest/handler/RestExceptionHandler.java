package com.example.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.core.constants.CodeErrorConstants;
import com.example.core.constants.ErrorConstants;
import com.example.core.constants.PersonConstants;
import com.example.core.exception.ApiError;
import com.example.core.exception.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ErrorConstants.NUMBER_BAD_FORMAT, "",
				CodeErrorConstants.CODE_ERROR_GENERIC);
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<Object> notFoundException(NotFoundException ex) {
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
