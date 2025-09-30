package com.innocito.riderservice.trip.model;

import com.innocito.riderservice.driver.DriverProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "o_trip_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldNameConstants
public class TripEvent {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "o_trip_events_id_seq")
  @SequenceGenerator(
    name = "o_trip_events_id_seq", sequenceName = "o_trip_events_id_seq", allocationSize = 1
  )
  private Long id;

  // TODO: is it mapped with trip table - id or trip_id ? but its having varchar(50) instead of bigint

  //  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "trip_id")
//  @org.hibernate.annotations.NotFound(action = org.hibernate.annotations.NotFoundAction.IGNORE)
  private String tripId;

  @Column(name = "previous_status")
  private String previousStatus;

  @Column(name = "current_status")
  private String currentStatus;

  @Column(name = "event_type")
  private String eventType;

  @Column(name = "event_timestamp")
  private LocalDateTime eventTimestamp;

  @Column(name = "provider_id")
  private Integer providerId;

  @Column(name = "payload")
  private String payload;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "driver_id")
  @org.hibernate.annotations.NotFound(action = org.hibernate.annotations.NotFoundAction.IGNORE)
  private DriverProfile driver;
}