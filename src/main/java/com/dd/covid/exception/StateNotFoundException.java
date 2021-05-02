package com.dd.covid.exception;

public class StateNotFoundException extends Exception {

    public StateNotFoundException() {
    }

    public StateNotFoundException(String message) {
        super(message);
    }

    public StateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
