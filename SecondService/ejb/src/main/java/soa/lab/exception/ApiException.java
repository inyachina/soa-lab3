package soa.lab.exception;

import lombok.Getter;


@Getter
public abstract class ApiException extends RuntimeException {
    private final int status;
    private final String defaultMessage;
    protected String message;


    public ApiException(int status, String defaultMessage) {
        this.status = status;
        this.defaultMessage = defaultMessage;
    }

    public ApiException(int status, String defaultMessage, String message) {
        this(status, defaultMessage);
        this.message = message;
    }
}
