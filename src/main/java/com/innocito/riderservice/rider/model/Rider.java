package com.innocito.riderservice.rider.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldNameConstants
@Table(name = "\"rider\"")
public class Rider {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rider")
  @SequenceGenerator(
    name = "seq_rider", sequenceName = "rider_id_seq", allocationSize = 1
  )
  private Long id;

  @Column(name = "uid")
  private String uid;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  @OneToMany(mappedBy = "rider", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private Set<RiderAddress> riderAddresses;

  @Override
  public boolean equals(Object object) {
    if (ObjectUtils.isEmpty(object)) {
      return false;
    }
    if (!(object instanceof Rider rider)) {
      return false;
    }
    return Objects.equals(getId(), rider.getId());
  }

  @Override
  public int hashCode() {
    if (id == null) {
      return System.identityHashCode(this);
    }
    return Long.hashCode(getId());
  }
}