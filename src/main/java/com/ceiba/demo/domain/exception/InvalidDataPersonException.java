package com.ceiba.demo.domain.exception;

public class InvalidDataPersonException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidDataPersonException(String message) {
        super(message);
    }
}
