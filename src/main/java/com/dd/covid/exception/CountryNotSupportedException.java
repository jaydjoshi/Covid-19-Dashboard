package com.dd.covid.exception;


public class CountryNotSupportedException extends Exception {
    public CountryNotSupportedException() {
        super();
    }

    public CountryNotSupportedException(String message) {
        super(message);
    }

    public CountryNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
