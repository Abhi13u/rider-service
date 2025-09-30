package com.innocito.riderservice.driver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_driver_profiles")
@FieldNameConstants
public class DriverProfile extends BaseData {
  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  //    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//    @ManyToOne
//    @JoinColumn(name = "transport_provider_id", referencedColumnName = "id")
//    private TransportationProviderProfile transportProvider;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "social_security_number")
  private String socialSecurityNumber;
  private Integer gender;
  private LocalDate dob;
  @Column(name = "user_status")
  private Integer userStatus;
  @Column(name = "phone_number")
  private String phoneNumber;


  private String address;
  private String city;
  private String state;
  @Column(name = "zip_code")
  private String zipCode;

//  @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//  private Set<Trip> trips;
}
