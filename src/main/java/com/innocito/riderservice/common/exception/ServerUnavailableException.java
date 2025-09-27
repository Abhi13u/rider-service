package com.innocito.riderservice.common.exception;

public class ServerUnavailableException extends RiderServiceException {
  private static final long serialVersionUID = 1L;

  public ServerUnavailableException(String key, String message) {
    super(key, message);
  }

  public ServerUnavailableException(String key, String message, Throwable cause) {
    super(key, message, cause);
  }
}
