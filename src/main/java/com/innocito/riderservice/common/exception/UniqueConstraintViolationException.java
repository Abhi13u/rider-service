package com.innocito.riderservice.common.exception;

public class UniqueConstraintViolationException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public UniqueConstraintViolationException(String key, String message) {
    super(key, message);
  }

  public UniqueConstraintViolationException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}