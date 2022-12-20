package soa.lab.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends ApiException {
    public BadRequestException() {
        super(400, "Bad request");
    }

    public BadRequestException(String message) {
        this();
        super.message = message;
    }
}
