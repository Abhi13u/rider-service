package com.innocito.riderservice.common.exception;

public class ConstraintFailedException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public ConstraintFailedException(String key, String message) {
    super(key, message);
  }

  public ConstraintFailedException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}