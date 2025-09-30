package com.innocito.riderservice.trip;

import com.innocito.riderservice.trip.model.TripEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripEventRepository extends JpaRepository<TripEvent, Long> {
  List<TripEvent> findByTripId(String tripId);

}