package com.innocito.riderservice.rider;

import com.innocito.riderservice.rider.dto.RiderDTO;
import com.innocito.riderservice.rider.dto.RiderUpdateDTO;

public interface RiderService {
  RiderDTO registerRider(RiderDTO riderDTO);

  RiderDTO updateRider(RiderUpdateDTO riderUpdateDTO);

  RiderDTO getRider(String id);
}
