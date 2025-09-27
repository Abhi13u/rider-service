package com.innocito.riderservice.rider.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RiderAddressLabelValidator implements ConstraintValidator<UniqueAddressLabels, List<RiderDTO.RiderAddressDTO>> {

  @Override
  public boolean isValid(List<RiderDTO.RiderAddressDTO> addresses, ConstraintValidatorContext context) {
    if (CollectionUtils.isEmpty(addresses)) {
      return true;
    }

    Set<RiderAddressLabel> existingLabels = new HashSet<>();
    for (RiderDTO.RiderAddressDTO address : addresses) {
      if (ObjectUtils.isNotEmpty(address.getLabel()) && !existingLabels.add(address.getLabel())) {
        return false;
      }
    }
    return true;
  }
}