package com.innocito.riderservice.trip.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripSummaryDTO {
  private String tripId;
  private CoordinatesDTO startLocation;
  private CoordinatesDTO endLocation;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private String status;
  private Double fare;
  private String driverName;

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  public static class CoordinatesDTO {
    private Double latitude;
    private Double longitude;
  }
}
