package com.innocito.riderservice.common.exception;

public class InvalidConfigurationException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public InvalidConfigurationException(String key, String message) {
    super(key, message);
  }

  public InvalidConfigurationException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}
