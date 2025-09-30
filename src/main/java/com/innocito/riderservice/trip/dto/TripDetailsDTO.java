package com.innocito.riderservice.trip.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TripDetailsDTO {
  private String tripId;
  private VehicleDetails vehicleDetails;
  private DriverDetails driverDetails;
  private RouteDetails routeDetails;
  private List<Events> events;
  private PaymentDetails paymentDetails;
  private Feedback feedback;

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class VehicleDetails {
    private String make;
    private String model;
    private String plateNo;
  }

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class DriverDetails {
    private String name;
    private String rating;
    private String maskedContact;
  }

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class RouteDetails {
    private List<TripSummaryDTO.CoordinatesDTO> path;
    private TripSummaryDTO.CoordinatesDTO startLocation;
    private TripSummaryDTO.CoordinatesDTO endLocation;
  }

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Events {
    private String event;
  }

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class PaymentDetails {
    private Double fare;
    // TODO: where to get these fields from
    private Double tax;
    private Double discount;
    private String mode;
  }

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Feedback {
    // TODO: where to get this field from
    private String rating;
    private String Comments;
  }
}