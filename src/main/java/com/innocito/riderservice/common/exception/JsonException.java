package com.innocito.riderservice.common.exception;

public class JsonException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public JsonException(String key, String message) {
    super(key, message);
  }

  public JsonException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}