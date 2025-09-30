package com.innocito.riderservice.trip.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldNameConstants
@Table(name = "m_trip_statuses")
public class TripStatus {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_trip_statuses_id_seq")
  @SequenceGenerator(
    name = "m_trip_statuses_id_seq", sequenceName = "m_trip_statuses_id_seq", allocationSize = 1
  )
  private Long id;

  @Column(name = "status_id")
  private Integer status;

  @Column(name = "description")
  private String description;
}