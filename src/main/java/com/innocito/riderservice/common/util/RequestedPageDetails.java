package com.innocito.riderservice.common.util;

import com.innocito.riderservice.common.exception.ErrorResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RequestedPageDetails {
  private Integer pageNumber;
  private Integer pageSize;
  private List<ErrorResponseDTO> errors;
}
