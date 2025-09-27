package com.innocito.riderservice.common.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Configuration
@ConfigurationProperties("rider-service")
public class RiderServiceConfig {
  private Contact contact;
  private MemoryCache memoryCache;

  @Data
  @RequiredArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class Contact {
    private String title;
    private String url;
    private String email;
    private String description;
    private String team;
    private String license;
    private String terms;
    private String version;
  }

  @Data
  @RequiredArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class MemoryCache {
    private String name;
    private boolean permitNullValues;
  }
}
