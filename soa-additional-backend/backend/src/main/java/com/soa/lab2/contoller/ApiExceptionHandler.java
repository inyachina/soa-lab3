package com.soa.lab2.contoller;

import com.soa.lab2.data.ExceptionResponse;
import com.soa.lab2.exception.ApiException;
import com.soa.lab2.exception.BadRequestException;
import com.soa.lab2.exception.ConnectionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.net.ConnectException;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity handleApiException(ApiException e) {
        String message = (e.getMessage() != null) ? e.getMessage() : e.getDefaultMessage();
        log.error("Api exception handler {}: {}", e.getClass().getName(), message);
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getClass().getName(), message));
    }

    @ExceptionHandler({
            MethodArgumentTypeMismatchException.class,
            IllegalArgumentException.class,
            HttpMessageNotReadableException.class,
    })
    public ResponseEntity toMapBadRequestException(Exception e) {
        return this.handleApiException(new BadRequestException());
    }

    @ExceptionHandler({
            ConnectException.class,
            WebClientResponseException.class
    })
    public ResponseEntity toMapConnectException(Exception e) {
        return this.handleApiException(new ConnectionException());
    }
}