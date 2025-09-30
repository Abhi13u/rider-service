package com.innocito.riderservice.trip;

import com.innocito.riderservice.trip.model.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripStatusRepository extends JpaRepository<TripStatus, Long> {
}
