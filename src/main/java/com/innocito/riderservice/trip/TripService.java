package com.innocito.riderservice.trip;

import com.innocito.riderservice.trip.dto.TripDetailsDTO;
import com.innocito.riderservice.trip.dto.TripSummaryDTO;

import java.util.List;

public interface TripService {
  TripDetailsDTO getTripDetails(String id);

  List<TripSummaryDTO> getTripSummary(String clientId);
}
