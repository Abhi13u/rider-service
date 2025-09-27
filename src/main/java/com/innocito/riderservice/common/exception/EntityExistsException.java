package com.innocito.riderservice.common.exception;

public class EntityExistsException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public EntityExistsException(String key, String message) {
    super(key, message);
  }

  public EntityExistsException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}