package com.innocito.riderservice.vehicle.model;

import com.innocito.riderservice.driver.BaseData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "o_vehicles")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldNameConstants
public class Vehicle extends BaseData {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "o_vehicles_id_seq")
  @SequenceGenerator(name = "o_vehicles_id_seq", sequenceName = "o_vehicles_id_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "transport_provider_id")
  private Long transportProviderId;

  @Column(name = "sentry_vehicle_id")
  private Integer sentryVehicleId;

  @Column(name = "vin")
  private String vin;

  @Column(name = "fleet_number")
  private String fleetNumber;

  @Column(name = "production_year")
  private Integer productionYear;

  @Column(name = "type_id")
  private Integer typeId;

  @Column(name = "make")
  private String make;

  @Column(name = "model")
  private String model;

  @Column(name = "color")
  private String color;

  @Column(name = "seat_number")
  private Integer seatNumber;

  @Column(name = "status_id")
  private Integer statusId;

  @Column(name = "dmv_license_plate_number")
  private String dmvLicensePlateNumber;

  @Column(name = "dmv_license_plate_category_id")
  private Integer dmvLicensePlateCategoryId;

  @Column(name = "dmv_state_code")
  private String dmvStateCode;

  @Column(name = "dmv_effective_date")
  private LocalDate dmvEffectiveDate;

  @Column(name = "dmv_expiration_date")
  private LocalDate dmvExpirationDate;

  @Column(name = "dmv_document_url")
  private String dmvDocumentUrl;

  @Column(name = "extra_license_number")
  private String extraLicenseNumber;

  @Column(name = "extra_type_id")
  private Integer extraTypeId;

  @Column(name = "extra_effective_date")
  private LocalDate extraEffectiveDate;

  @Column(name = "extra_expiration_date")
  private LocalDate extraExpirationDate;

  @Column(name = "extra_document_url")
  private String extraDocumentUrl;

  @Column(name = "insurance_policy_number")
  private String insurancePolicyNumber;

  @Column(name = "insurance_insurer_name")
  private String insuranceInsurerName;

  @Column(name = "insurance_effective_date")
  private LocalDate insuranceEffectiveDate;

  @Column(name = "insurance_expiration_date")
  private LocalDate insuranceExpirationDate;

  @Column(name = "insurance_document_url")
  private String insuranceDocumentUrl;

  @Column(name = "inspection_effective_date")
  private LocalDate inspectionEffectiveDate;

  @Column(name = "inspection_expiration_date")
  private LocalDate inspectionExpirationDate;

  @Column(name = "inspection_document_url")
  private String inspectionDocumentUrl;

  @Column(name = "vehicle_type")
  private String vehicleType;
}