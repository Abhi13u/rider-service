package com.innocito.riderservice.common.exception;

public class NotFoundException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public NotFoundException(String key, String message) {
    super(key, message);
  }

  public NotFoundException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}