package com.innocito.riderservice.driver;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@FieldNameConstants
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseData {
  @CreatedDate
  @Column(name = "created_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;
  @LastModifiedDate
  @Column(name = "updated_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedOn;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_on")
  private Date deletedOn;
  @CreatedBy
  @Column(name = "created_by")
  private Long createdBy;
  @LastModifiedBy
  @Column(name = "updated_by")
  private Long updatedBy;
  @Column(name = "deleted_by")
  private Long deletedBy;
}