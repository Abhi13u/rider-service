package com.innocito.riderservice.common.exception;

import lombok.Getter;

@Getter
public class RiderServiceException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private final String key;

  public RiderServiceException(String key, String message) {
    super(message);
    this.key = key;
  }

  public RiderServiceException(String key, String message, Throwable cause) {
    super(message, cause);
    this.key = key;
  }
}
