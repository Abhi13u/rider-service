package com.innocito.riderservice.common.util;

import com.innocito.riderservice.common.exception.ErrorResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseUtil {
  public <T> ApiResponse<T> success(T data, String message) {
    return ApiResponse.<T>builder()
      .message(message)
      .data(data).build();
  }

  public <T> ApiResponse<T> success(T data, String message, PaginationDetails pagination) {
    return ApiResponse.<T>builder()
      .message(message)
      .data(data)
      .pagination(pagination).build();
  }

  public <T> ApiResponse<T> error(String message, List<ErrorResponseDTO> errors) {
    return ApiResponse.<T>builder()
      .message(message)
      .errors(errors).build();
  }
}