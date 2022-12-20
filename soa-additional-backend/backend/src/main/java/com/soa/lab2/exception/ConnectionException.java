package com.soa.lab2.exception;

import org.springframework.http.HttpStatus;

public class ConnectionException extends ApiException {

    public ConnectionException() {
        super(HttpStatus.SERVICE_UNAVAILABLE, "Couldn't connect to main service");
    }

    public ConnectionException(String message) {
        this();
        super.message = message;
    }
}
