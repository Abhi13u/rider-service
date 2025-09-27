package com.innocito.riderservice.common.exception;

public class LimitConstraintException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public LimitConstraintException(String key, String message) {
    super(key, message);
  }

  public LimitConstraintException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}
