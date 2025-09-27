package com.innocito.riderservice.common.exception;

public class InvalidInputException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public InvalidInputException(String key, String message) {
    super(key, message);
  }

  public InvalidInputException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}