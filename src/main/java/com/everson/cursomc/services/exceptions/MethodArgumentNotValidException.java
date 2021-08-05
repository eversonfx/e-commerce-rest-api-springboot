package com.everson.cursomc.services.exceptions;

public class MethodArgumentNotValidException extends RuntimeException {
    public MethodArgumentNotValidException(String msg) {
        super(msg);
    }

    public MethodArgumentNotValidException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
