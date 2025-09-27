package com.innocito.riderservice.util;

import com.innocito.riderservice.common.exception.ErrorResponseDTO;
import com.innocito.riderservice.common.util.ApiResponse;
import com.innocito.riderservice.common.util.PaginationDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseUtils {
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