package com.cs.assignment.exception;

import org.springframework.http.HttpStatus;

public class SmoothieException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String message;

  private Exception exception;

  private HttpStatus status;

  public SmoothieException(Exception e) {
    super(e);
  }

  public SmoothieException(String message, Exception e) {
    super(message, e);
    this.message = message;
    exception = e;
  }

  public SmoothieException(String message, Exception e, HttpStatus status) {
    super(message, e);
    this.message = message;
    exception = e;
    this.status = status;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Exception getException() {
    return exception;
  }

  public void setException(Exception exception) {
    this.exception = exception;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }
}
