package com.ceiba.demo.domain.exception;

public class NotFoundPersonException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotFoundPersonException(String message) {
        super(message);
    }
}
