package com.innocito.riderservice.trip;

import com.innocito.riderservice.trip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
  Trip findByTripId(String tripId);

  List<Trip> findByClientId(String clientId);
}
