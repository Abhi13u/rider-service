package com.innocito.riderservice.rider;

import com.innocito.riderservice.rider.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
  Rider findByUid(String uid);

  Rider findByEmail(String email);
}
