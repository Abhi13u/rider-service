package com.innocito.riderservice.common.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends RiderServiceException {

  private static final long serialVersionUID = 1L;

  private final List<ErrorResponseDTO> errors;

  public ValidationException(String key, String message, List<ErrorResponseDTO> errors) {
    super(key, message);
    this.errors = errors;
  }

  public ValidationException(String key, String message, List<ErrorResponseDTO> errors, Throwable cause) {
    super(key, message, cause);
    this.errors = errors;
  }
}