package com.innocito.riderservice.common.exception;

public class ExternalApiException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public ExternalApiException(String key, String message) {
    super(key, message);
  }

  public ExternalApiException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}