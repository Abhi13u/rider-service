package com.innocito.riderservice.common.exception;

public class EnumNotFoundException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public EnumNotFoundException(String key, String message) {
    super(key, message);
  }

  public EnumNotFoundException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}