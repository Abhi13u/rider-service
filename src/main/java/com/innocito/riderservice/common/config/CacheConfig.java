package com.innocito.riderservice.common.config;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheConfig {
  @Autowired
  RiderServiceConfig riderServiceConfig;

  public Cache<String, Object> cacheManager() {
    Cache2kBuilder cache2kBuilder = Cache2kBuilder.of(String.class, Object.class)
      .name(riderServiceConfig.getMemoryCache().getName())
      .entryCapacity(1000)
      .permitNullValues(riderServiceConfig.getMemoryCache().isPermitNullValues());
    return cache2kBuilder.build();
  }
}