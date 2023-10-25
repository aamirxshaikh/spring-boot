package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
    ErrorResponse errorResponse = new ErrorResponse(
            ex.getMessage(),
            ex,
            HttpStatus.NOT_FOUND,
            ZonedDateTime.now()
    );

    return new ResponseEntity<>(
            errorResponse,
            HttpStatus.NOT_FOUND
    );
  }
}
