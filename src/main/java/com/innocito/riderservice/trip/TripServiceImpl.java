package com.innocito.riderservice.trip;

import com.innocito.riderservice.common.exception.ErrorMessages;
import com.innocito.riderservice.common.exception.NotFoundException;
import com.innocito.riderservice.common.util.BasicUtils;
import com.innocito.riderservice.driver.DriverProfile;
import com.innocito.riderservice.trip.dto.TripDetailsDTO;
import com.innocito.riderservice.trip.dto.TripStatusFactory;
import com.innocito.riderservice.trip.dto.TripSummaryDTO;
import com.innocito.riderservice.trip.model.Trip;
import com.innocito.riderservice.trip.model.TripEvent;
import com.innocito.riderservice.trip.model.TripLocationHistory;
import com.innocito.riderservice.vehicle.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.innocito.riderservice.common.constants.AppConstants.SPACE_DELIMITER;

@Service
@Slf4j
public class TripServiceImpl implements TripService {
  @Autowired
  TripRepository tripRepository;

  @Autowired
  TripEventRepository tripEventRepository;

  @Autowired
  TripStatusFactory tripStatusFactory;

  @Override
  @Transactional
  public List<TripSummaryDTO> getTripSummary(String clientId) {
    List<Trip> tripList = tripRepository.findByClientId(clientId);
    List<TripSummaryDTO> tripSummaryDTOS = new ArrayList<>();
    for (Trip trip : tripList) {
      TripSummaryDTO tripSummaryDTO = TripSummaryDTO.builder()
        .tripId(trip.getTripId())
        .startLocation(TripSummaryDTO.CoordinatesDTO.builder()
          .latitude(trip.getPickupLat())
          .longitude(trip.getPickupLng())
          .build())
        .endLocation(TripSummaryDTO.CoordinatesDTO.builder()
          .latitude(trip.getDropOffLat())
          .longitude(trip.getDropOffLng())
          .build())
        .startTime(trip.getPickUpTimestamp())
        .endTime(trip.getDropOffTimestamp())
        .status(tripStatusFactory.getTripStatusById(trip.getStatusId()))
        .fare(trip.getFare())
        // TODO: the driver id, its linked to which table which field?
        .build();
      DriverProfile driver = trip.getDriver();
      if (ObjectUtils.isNotEmpty(driver)) {
        tripSummaryDTO.setDriverName(driver.getFirstName() + SPACE_DELIMITER + driver.getMiddleName() + SPACE_DELIMITER + driver.getLastName());
      }
      tripSummaryDTOS.add(tripSummaryDTO);
    }
    return tripSummaryDTOS;
  }

  @Override
  @Transactional
  public TripDetailsDTO getTripDetails(String id) {
    Trip trip = getTripByID(id);
    List<TripSummaryDTO.CoordinatesDTO> pathPoints = trip.getTripLocationHistories()
      .stream()
      .sorted(Comparator.comparing(TripLocationHistory::getEventTime))
      .map(loc -> TripSummaryDTO.CoordinatesDTO.builder()
        .latitude(loc.getLocation().getY())
        .longitude(loc.getLocation().getX())
        .build())
      .collect(Collectors.toList());

    List<TripEvent> tripEvents = tripEventRepository.findByTripId(id);
    List<TripDetailsDTO.Events> events = tripEvents
      .stream()
      .sorted(Comparator.comparing(TripEvent::getEventTimestamp))
      .map(e -> TripDetailsDTO.Events.builder()
        .event(e.getEventType())
        .build())
      .toList();

    TripDetailsDTO tripDetailsDTO = TripDetailsDTO.builder()
      .tripId(trip.getTripId())
      .routeDetails(TripDetailsDTO.RouteDetails.builder()
        .startLocation(TripSummaryDTO.CoordinatesDTO.builder()
          .latitude(trip.getPickupLat())
          .longitude(trip.getPickupLng())
          .build())
        .endLocation(TripSummaryDTO.CoordinatesDTO.builder()
          .latitude(trip.getDropOffLat())
          .longitude(trip.getDropOffLng())
          .build())
        .path(pathPoints)
        .build())
      .feedback(TripDetailsDTO.Feedback.builder()
        .Comments(trip.getComments())
        .build())
      .events(events)
      .paymentDetails(TripDetailsDTO.PaymentDetails.builder()
        .fare(trip.getFare())
        .build())
      .build();
    DriverProfile driver = trip.getDriver();
    if (ObjectUtils.isNotEmpty(driver)) {
      tripDetailsDTO.setDriverDetails(TripDetailsDTO.DriverDetails.builder()
        .name(driver.getFirstName() + SPACE_DELIMITER + driver.getMiddleName() + SPACE_DELIMITER + driver.getLastName())
        .maskedContact(BasicUtils.maskMobileNumber(driver.getPhoneNumber()))
        .build());
    }
    Vehicle vehicle = trip.getVehicle();
    if (ObjectUtils.isNotEmpty(vehicle)) {
      tripDetailsDTO.setVehicleDetails(TripDetailsDTO.VehicleDetails.builder()
        .make(vehicle.getMake())
        .model(vehicle.getModel())
        .plateNo(vehicle.getDmvLicensePlateNumber())
        .build());
    }
    return tripDetailsDTO;
  }

  private Trip getTripByID(String id) {
    Trip trip = tripRepository.findByTripId(id);
    if (ObjectUtils.isEmpty(trip)) {
      throw new NotFoundException(Trip.class.getSimpleName(), String.format(" with id: " + id,
        ErrorMessages.NOT_FOUND));
    }
    return trip;
  }
}
