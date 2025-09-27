package com.innocito.riderservice.common.beans;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.MDC;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;

import static com.innocito.riderservice.common.constants.AppConstants.CORRELATION_ID_HEADER;
import static com.innocito.riderservice.common.constants.AppConstants.MDC_KEY;

@Configuration
public class BeanConfig {

  @Bean(name = "restTemplateWithConnectReadTimeout")
  RestTemplate restTemplateTimeoutWithRequestFactory() {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setConnectTimeout(5000);
    requestFactory.setReadTimeout(5000);
    return new RestTemplate(requestFactory);
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }

  @Bean
  public ClientHttpRequestInterceptor correlationIdInterceptor() {
    return (request, body, execution) -> {
      String correlationId = MDC.get(MDC_KEY);
      if (correlationId != null) {
        request.getHeaders().add(CORRELATION_ID_HEADER, correlationId);
      }
      return execution.execute(request, body);
    };
  }

  @Bean
  public RestTemplate getRestTemplate(ClientHttpRequestInterceptor correlationIdInterceptor) {
    return new RestTemplateBuilder()
      .connectTimeout(Duration.ofMillis(5000))
      .readTimeout(Duration.ofMillis(5000))
      .additionalInterceptors(Collections.singletonList(correlationIdInterceptor))
      .build();
  }
}