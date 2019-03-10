package com.ceiba.demo.domain.model.validation;

import com.ceiba.demo.domain.exception.InvalidDataPersonException;

public class  ValidationPerson {
	
	public static void validateNotNull(Object attribute, String message) throws InvalidDataPersonException{
		
		if(attribute == null) {
			throw new InvalidDataPersonException(message);
		}
	}
	public static void validateAge(int age, String message) throws InvalidDataPersonException{
		
		if(age < 0) {
			throw new InvalidDataPersonException(message);
		}
	}
}
