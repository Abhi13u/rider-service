package com.innocito.riderservice.common.exception;

public class TimeOutException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public TimeOutException(String key, String message) {
    super(key, message);
  }

  public TimeOutException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}