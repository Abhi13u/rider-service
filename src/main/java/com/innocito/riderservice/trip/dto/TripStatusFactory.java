package com.innocito.riderservice.trip.dto;

import com.innocito.riderservice.common.exception.ErrorMessages;
import com.innocito.riderservice.common.exception.NotFoundException;
import com.innocito.riderservice.trip.TripStatusRepository;
import com.innocito.riderservice.trip.model.TripStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: if we link tripstatus to trip table, that would be better and avoid multiple calls;
@Component
public class TripStatusFactory {
  private final Map<Integer, String> tripStatusMap = new HashMap();
  private TripStatusRepository tripStatusRepository;

  @Autowired
  public TripStatusFactory(TripStatusRepository tripStatusRepository) {
    List<TripStatus> tripStatuses = tripStatusRepository.findAll();
    for (TripStatus tripStatus : tripStatuses) {
      this.tripStatusMap.put(tripStatus.getStatus(), tripStatus.getDescription());
    }
  }

  public Map<Integer, String> getAllTripStatus() {
    return tripStatusMap;
  }

  public String getTripStatusById(Integer id) {
    String status = tripStatusMap.get(id);
    if (StringUtils.isEmpty(status)) {
      throw new NotFoundException(TripStatus.class.getSimpleName(), String.format(" with id: " + id,
        ErrorMessages.NOT_FOUND));
    }
    return status;
  }

}
