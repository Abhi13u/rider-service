package com.innocito.riderservice.rider.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.innocito.riderservice.common.exception.InvalidConfigurationException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static com.innocito.riderservice.common.exception.ErrorMessages.NOT_SUPPORTED;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public enum RiderAddressLabel {
  HOME,
  OFFICE;

  // TODO: if this is not fixed, we can just take from input

  public static RiderAddressLabel fromValue(String value) {
    return Arrays.stream(RiderAddressLabel.values())
      .filter(riderAddressLabel -> value != null && value.toUpperCase().contains(riderAddressLabel.name()))
      .findFirst()
      .orElseThrow(() -> new InvalidConfigurationException(RiderAddressLabel.class.getSimpleName(), String.format(NOT_SUPPORTED,
        value)));
  }

  @JsonValue
  public String getValue() {
    return name().toLowerCase();
  }
}
