package com.innocito.riderservice.common.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

import static com.innocito.riderservice.common.constants.AppConstants.CORRELATION_ID_HEADER;
import static com.innocito.riderservice.common.constants.AppConstants.MDC_KEY;

@Component
public class CorrelationIdFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    try {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      String correlationId = httpRequest.getHeader(CORRELATION_ID_HEADER);
      if (StringUtils.isBlank(correlationId)) {
        correlationId = UUID.randomUUID().toString();
      }
      MDC.put(MDC_KEY, correlationId);
      chain.doFilter(request, response);
    } finally {
      MDC.remove(MDC_KEY);
    }
  }
}