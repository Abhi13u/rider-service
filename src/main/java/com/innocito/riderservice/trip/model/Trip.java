package com.innocito.riderservice.trip.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innocito.riderservice.driver.BaseData;
import com.innocito.riderservice.driver.DriverProfile;
import com.innocito.riderservice.vehicle.model.Vehicle;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldNameConstants
@Table(name = "o_trips")
public class Trip extends BaseData {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "o_trips_id_seq")
  @SequenceGenerator(
    name = "o_trips_id_seq", sequenceName = "o_trips_id_seq", allocationSize = 1
  )
  private Long id;

  @Column(name = "trip_id")
  private String tripId;

  @Column(name = "is_copy_of")
  private String isCopyOf;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "reason_id")
  private Integer reasonId;

  @Column(name = "reason_name")
  private String reasonName;

  @Column(name = "service_level_code")
  private String serviceLevelCode;

  @Column(name = "vehicle_equipment_codes")
  private String[] vehicleEquipmentCodes;

  @Column(name = "facility_phone")
  private String facilityPhone;

  @Column(name = "facility_phone_ext")
  private String facilityPhoneExt;

  @Column(name = "ordering_provider_name")
  private String orderingProviderName;

  @Column(name = "ordering_provider_npi")
  private String orderingProviderNpi;

  @Column(name = "client_id")
  private String clientId;

  @Column(name = "insurance_provider_id")
  private Integer insuranceProviderId;

  @Column(name = "client_first_name")
  private String clientFirstName;

  @Column(name = "client_last_name")
  private String clientLastName;

  @Column(name = "client_gender")
  private String clientGender;

  @Column(name = "client_birth_date")
  private LocalDate clientBirthDate;

  @Column(name = "client_county_code")
  private String clientCountyCode;

  @Column(name = "is_low_vehicle_required")
  private Boolean isLowVehicleRequired;

  @Column(name = "escort_personal_care_attendant_count")
  private Integer escortPersonalCareAttendantCount;

  @Column(name = "escort_adult_count")
  private Integer escortAdultCount;

  @Column(name = "escort_child_count")
  private Integer escortChildCount;

  @Column(name = "escort_child_seat_count")
  private Integer escortChildSeatCount;

  @Column(name = "escort_animal_count")
  private Integer escortAnimalCount;

  @Column(name = "wc_seat_count")
  private Integer wcSeatCount;

  @Column(name = "pickup_name")
  private String pickupName;

  @Column(name = "pickup_address")
  private String pickupAddress;

  @Column(name = "pickup_building")
  private String pickupBuilding;

  @Column(name = "pickup_apartment")
  private String pickupApartment;

  @Column(name = "pickup_city")
  private String pickupCity;

  @Column(name = "pickup_county_code")
  private String pickupCountyCode;

  @Column(name = "pickup_state_code")
  private String pickupStateCode;

  @Column(name = "pickup_zip_code")
  private String pickupZipCode;

  @Column(name = "pickup_phone")
  private String pickupPhone;

  @Column(name = "pickup_phone_ext")
  private String pickupPhoneExt;

  @Column(name = "pickup_alternate_phone")
  private String pickupAlternatePhone;

  @Column(name = "pickup_alternate_phone_ext")
  private String pickupAlternatePhoneExt;

  @Column(name = "pickup_directions")
  private String pickupDirections;

  @Column(name = "pickup_lat")
  private Double pickupLat;

  @Column(name = "pickup_lng")
  private Double pickupLng;

  @Column(name = "drop_off_name")
  private String dropOffName;

  @Column(name = "drop_off_address")
  private String dropOffAddress;

  @Column(name = "drop_off_building")
  private String dropOffBuilding;

  @Column(name = "drop_off_apartment")
  private String dropOffApartment;

  @Column(name = "drop_off_city")
  private String dropOffCity;

  @Column(name = "drop_off_county_code")
  private String dropOffCountyCode;

  @Column(name = "drop_off_state_code")
  private String dropOffStateCode;

  @Column(name = "drop_off_zip_code")
  private String dropOffZipCode;

  @Column(name = "drop_off_directions")
  private String dropOffDirections;

  @Column(name = "drop_off_lat")
  private Double dropOffLat;

  @Column(name = "drop_off_lng")
  private Double dropOffLng;

  @Column(name = "scheduled_pick_up_timestamp")
  private LocalDateTime scheduledPickUpTimestamp;

  @Column(name = "scheduled_pick_up_timestamp_source_id")
  private Integer scheduledPickUpTimestampSourceId;

  @Column(name = "latest_pick_up_timestamp")
  private LocalDateTime latestPickUpTimestamp;

  @Column(name = "scheduled_drop_off_timestamp")
  private LocalDateTime scheduledDropOffTimestamp;

  @Column(name = "scheduled_drop_off_timestamp_source_id")
  private Integer scheduledDropOffTimestampSourceId;

  @Column(name = "pick_up_arrival_timestamp")
  private LocalDateTime pickUpArrivalTimestamp;

  @Column(name = "pick_up_timestamp")
  private LocalDateTime pickUpTimestamp;

  @Column(name = "drop_off_timestamp")
  private LocalDateTime dropOffTimestamp;

  @Column(name = "mileage")
  private Double mileage;

  @Column(name = "is_congestion_surcharge_route")
  private Boolean isCongestionSurchargeRoute;

  @Column(name = "is_covid_eligible_transport_required")
  private Boolean isCovidEligibleTransportRequired;

  @Column(name = "last_modified_at")
  private LocalDateTime lastModifiedAt;

  @Column(name = "assignment_type_code")
  private String assignmentTypeCode;

  @Column(name = "acceptance_status_id")
  private Integer acceptanceStatusId;

  @Column(name = "is_done_by_not_integrated_provider")
  private Boolean isDoneByNotIntegratedProvider;

  @Column(name = "status_id")
  private Integer statusId;

  @Column(name = "is_confirmed")
  private Boolean isConfirmed;

  @Column(name = "cancel_reason_id")
  private Integer cancelReasonId;

  @Column(name = "cancel_note")
  private String cancelNote;

  @Column(name = "notes_from_provider")
  private String notesFromProvider;

  @Column(name = "gross_cost")
  private Double grossCost;

  @Column(name = "initial_cost")
  private Double initialCost;

  @Column(name = "procedures_cost")
  private Double proceduresCost;

  @Column(name = "pick_up_arrival_cost")
  private Double pickUpArrivalCost;

  @Column(name = "delivery_cost")
  private Double deliveryCost;

  @Column(name = "adjustment")
  private Double adjustment;

  @Column(name = "adjustment_note")
  private String adjustmentNote;

  @Column(name = "actual_cost")
  private Double actualCost;

  @Column(name = "fare")
  private Double fare;

  @Column(name = "late_cancel_cost")
  private Double lateCancelCost;

  @Column(name = "no_show_cost")
  private Double noShowCost;

  @Column(name = "general_incentive_cost")
  private Double generalIncentiveCost;

  @Column(name = "toll_cost")
  private Double tollCost;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vehicle_id")
  @org.hibernate.annotations.NotFound(action = org.hibernate.annotations.NotFoundAction.IGNORE)
  private Vehicle vehicle;

  @Column(name = "license_plate_number")
  private String licensePlateNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "driver_id")
  @org.hibernate.annotations.NotFound(action = org.hibernate.annotations.NotFoundAction.IGNORE)
  private DriverProfile driver;

  @Column(name = "license_number")
  private String licenseNumber;

  @Column(name = "license_state_code")
  private String licenseStateCode;

  @Column(name = "billing_status_id")
  private Integer billingStatusId;

  @Column(name = "billing_status_name")
  private String billingStatusName;

  @Column(name = "billing_note")
  private String billingNote;

  @Column(name = "payable_amount")
  private Double payableAmount;

  @Column(name = "payable_late_cancel_cost")
  private Double payableLateCancelCost;

  @Column(name = "payable_no_show_cost")
  private Double payableNoShowCost;

  @Column(name = "payable_general_incentive_cost")
  private Double payableGeneralIncentiveCost;

  @Column(name = "payable_toll_cost")
  private Double payableTollCost;

  @Column(name = "toll_rejection_reason")
  private String tollRejectionReason;

  @Column(name = "toll_rejection_note")
  private String tollRejectionNote;

  @Column(name = "comments")
  private String comments;

  @Column(name = "transport_provider_id")
  private Long transportProviderId;

  @Column(name = "trip_provider")
  private Long tripProvider;

  @Column(name = "last_sentry_sync_successful")
  private Boolean lastSentrySyncSuccessful;

  @Column(name = "last_sentry_sync_time")
  private LocalDateTime lastSentrySyncTime;

  @Column(name = "last_sentry_sync_remarks")
  private String lastSentrySyncRemarks;

//  @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//  private Set<TripEvent> tripEvents;

  @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private Set<TripLocationHistory> tripLocationHistories;
}