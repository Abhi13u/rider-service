package com.innocito.riderservice.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innocito.riderservice.common.exception.ErrorResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
  private String message;
  private T data;
  private List<ErrorResponseDTO> errors;
  private PaginationDetails pagination;
}