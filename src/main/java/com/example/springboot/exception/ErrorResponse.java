package com.example.springboot.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorResponse {
  private final String message;
  private final Throwable throwable;
  private final HttpStatus httpStatus;
  private final ZonedDateTime zonedDateTime;

  public ErrorResponse(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
    this.message = message;
    this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.zonedDateTime = zonedDateTime;
  }

  public String getMessage() {
    return message;
  }

  public Throwable getThrowable() {
    return throwable;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ZonedDateTime getZonedDateTime() {
    return zonedDateTime;
  }

  @Override
  public String toString() {
    return "ErrorResponse{" +
            "message='" + message + '\'' +
            ", throwable=" + throwable +
            ", httpStatus=" + httpStatus +
            ", zonedDateTime=" + zonedDateTime +
            '}';
  }
}
