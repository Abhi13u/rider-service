package com.innocito.riderservice.rider.dto;

import com.innocito.riderservice.rider.model.Rider;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RiderDTOWrapper {
  public static RiderDTO buildRiderDTOFromRider(Rider rider) {
    List<RiderDTO.RiderAddressDTO> addressDTOs = new ArrayList<>();
    if (ObjectUtils.isNotEmpty(rider.getRiderAddresses())) {
      addressDTOs = rider.getRiderAddresses().stream()
        .map(address -> RiderDTO.RiderAddressDTO.builder()
          .label(address.getLabel())
          .line1(address.getLine1())
          .line2(address.getLine2())
          .city(address.getCity())
          .state(address.getState())
          .country(address.getCountry())
          .postalCode(address.getPostalCode())
          .createdAt(address.getCreatedAt())
          .updatedAt(address.getUpdatedAt())
          .build())
        .collect(Collectors.toList());
    }

    return RiderDTO.builder()
      .uid(rider.getUid())
      .firstName(rider.getFirstName())
      .lastName(rider.getLastName())
      .phoneNumber(rider.getPhoneNumber())
      .email(rider.getEmail())
      .riderAddresses(addressDTOs)
      .createdAt(rider.getCreatedAt())
      .updatedAt(rider.getUpdatedAt())
      .build();
  }
}
