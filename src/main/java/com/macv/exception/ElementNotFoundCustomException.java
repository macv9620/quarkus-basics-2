package com.macv.exception;

public class ElementNotFoundCustomException extends RuntimeException{
    public ElementNotFoundCustomException(String message) {
        super(message);
    }
}
