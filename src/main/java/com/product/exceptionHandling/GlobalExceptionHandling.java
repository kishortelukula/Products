package com.product.exceptionHandling;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
    
    @ExceptionHandler(BadrequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ProblemDetail> badrequestData(BadrequestException exception) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        detail.setProperty("Message", exception.getMessage());
        detail.setType(URI.create("/error"));
        detail.setStatus(HttpStatus.BAD_REQUEST);
        detail.setProperty("Error", "Bad Request");
        return ResponseEntity.ok().body(detail);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ProblemDetail> userNotFoundData(UserNotFoundException exception) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        detail.setProperty("Message", exception.getMessage());
        detail.setType(URI.create("/error"));
        detail.setStatus(HttpStatus.NOT_FOUND);
        detail.setProperty("Error", "Not Found");
        return ResponseEntity.ok().body(detail);
    }
}

