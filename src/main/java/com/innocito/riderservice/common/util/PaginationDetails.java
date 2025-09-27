package com.innocito.riderservice.common.util;

import lombok.Data;

@Data
public class PaginationDetails {
  private int pageNumber;
  private int requestedPageSize;
  private long totalElements;
  private int totalPages;
  private int currentPageSize;
}