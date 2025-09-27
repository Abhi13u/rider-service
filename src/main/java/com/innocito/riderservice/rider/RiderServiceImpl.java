package com.innocito.riderservice.rider;

import com.innocito.riderservice.common.exception.EntityExistsException;
import com.innocito.riderservice.common.exception.ErrorMessages;
import com.innocito.riderservice.common.exception.NotFoundException;
import com.innocito.riderservice.rider.dto.RiderAddressLabel;
import com.innocito.riderservice.rider.dto.RiderDTO;
import com.innocito.riderservice.rider.dto.RiderDTOWrapper;
import com.innocito.riderservice.rider.dto.RiderUpdateDTO;
import com.innocito.riderservice.rider.model.Rider;
import com.innocito.riderservice.rider.model.RiderAddress;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RiderServiceImpl implements RiderService {
  @Autowired
  private RiderRepository riderRepository;

  @Override
  public RiderDTO registerRider(RiderDTO riderDTO) {
    if(ObjectUtils.isNotEmpty(riderRepository.findByEmail(riderDTO.getEmail()))){
      throw new EntityExistsException(Rider.class.getSimpleName(), String.format(
        "with email: " + riderDTO.getEmail(), ErrorMessages.ALREADY_EXISTS));
    }
    Rider rider = Rider.builder()
      .uid(UUID.randomUUID().toString())
      .firstName(riderDTO.getFirstName())
      .lastName(riderDTO.getLastName())
      .phoneNumber(riderDTO.getPhoneNumber())
      .email(riderDTO.getEmail())
      .createdAt(new Date())
      .updatedAt(new Date())
      .build();

    if (CollectionUtils.isNotEmpty(riderDTO.getRiderAddresses())) {
      Set<RiderAddress> addresses = riderDTO.getRiderAddresses().stream()
        .map(riderAddressDTO -> RiderAddress.builder()
          .label(riderAddressDTO.getLabel())
          .line1(riderAddressDTO.getLine1())
          .line2(riderAddressDTO.getLine2())
          .city(riderAddressDTO.getCity())
          .state(riderAddressDTO.getState())
          .country(riderAddressDTO.getCountry())
          .postalCode(riderAddressDTO.getPostalCode())
          .createdAt(new Date())
          .updatedAt(new Date())
          .rider(rider)
          .build())
        .collect(Collectors.toSet());
      rider.setRiderAddresses(addresses);
    }

    riderRepository.save(rider);
    return RiderDTOWrapper.buildRiderDTOFromRider(rider);
  }

  @Override
  @Transactional
  public RiderDTO updateRider(RiderUpdateDTO riderUpdateDTO) {
    Rider rider = getRiderByEmail(riderUpdateDTO.getEmail());
    rider.setFirstName(ObjectUtils.defaultIfNull(riderUpdateDTO.getFirstName(), rider.getFirstName()));
    rider.setLastName(ObjectUtils.defaultIfNull(riderUpdateDTO.getLastName(), rider.getLastName()));
    rider.setPhoneNumber(ObjectUtils.defaultIfNull(riderUpdateDTO.getPhoneNumber(), rider.getLastName()));

    if (CollectionUtils.isNotEmpty(riderUpdateDTO.getRiderAddresses())) {
      Map<RiderAddressLabel, RiderDTO.RiderAddressDTO> addressMap = riderUpdateDTO.getRiderAddresses()
        .stream()
        .filter(riderAddressDTO -> ObjectUtils.isNotEmpty(riderAddressDTO.getLabel()))
        .collect(Collectors.toMap(RiderDTO.RiderAddressDTO::getLabel, riderAddressDTO -> riderAddressDTO));

      rider.getRiderAddresses().removeIf(existingAddress -> {
        RiderDTO.RiderAddressDTO riderAddressDTO = addressMap.remove(existingAddress.getLabel());
        if (ObjectUtils.isEmpty(riderAddressDTO)) {
          return true;
        }

        existingAddress.setLine1(ObjectUtils.defaultIfNull(riderAddressDTO.getLine1(), existingAddress.getLine1()));
        existingAddress.setLine2(ObjectUtils.defaultIfNull(riderAddressDTO.getLine2(), existingAddress.getLine2()));
        existingAddress.setCity(ObjectUtils.defaultIfNull(riderAddressDTO.getCity(), existingAddress.getCity()));
        existingAddress.setState(ObjectUtils.defaultIfNull(riderAddressDTO.getState(), existingAddress.getState()));
        existingAddress.setCountry(ObjectUtils.defaultIfNull(riderAddressDTO.getCountry(), existingAddress.getCountry()));
        existingAddress.setPostalCode(ObjectUtils.defaultIfNull(riderAddressDTO.getPostalCode(), existingAddress.getPostalCode()));
        existingAddress.setUpdatedAt(new Date());
        return false;
      });

      addressMap.values().forEach(dto -> rider.getRiderAddresses().add(
        RiderAddress.builder()
          .label(dto.getLabel())
          .line1(dto.getLine1())
          .line2(dto.getLine2())
          .city(dto.getCity())
          .state(dto.getState())
          .country(dto.getCountry())
          .postalCode(dto.getPostalCode())
          .createdAt(new Date())
          .updatedAt(new Date())
          .rider(rider)
          .build()
      ));
    } else {
      rider.getRiderAddresses().clear();
    }

    rider.setUpdatedAt(new Date());
    riderRepository.save(rider);
    return RiderDTOWrapper.buildRiderDTOFromRider(rider);
  }

  @Override
  @Transactional
  public RiderDTO getRider(String id) {
    return RiderDTOWrapper.buildRiderDTOFromRider(getRiderByUID(id));
  }

  private Rider getRiderByUID(String uid) {
    Rider rider = riderRepository.findByUid(uid);
    if (ObjectUtils.isEmpty(rider)) {
      throw new NotFoundException(Rider.class.getSimpleName(), String.format(" with uid: " + uid,
        ErrorMessages.NOT_FOUND));
    }
    return rider;
  }

  private Rider getRiderByEmail(String email) {
    Rider rider = riderRepository.findByEmail(email);
    if (ObjectUtils.isEmpty(rider)) {
      throw new NotFoundException(Rider.class.getSimpleName(), String.format(" with email: " + email,
        ErrorMessages.NOT_FOUND));
    }
    return rider;
  }
}
