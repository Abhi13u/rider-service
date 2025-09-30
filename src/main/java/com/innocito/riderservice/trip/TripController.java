package com.innocito.riderservice.trip;

import com.innocito.riderservice.trip.dto.TripDetailsDTO;
import com.innocito.riderservice.trip.dto.TripSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripController {
  @Autowired
  TripService tripService;

  @GetMapping(path = "/trip/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TripDetailsDTO> getTripDetails(@PathVariable String id) {
    return new ResponseEntity<>(tripService.getTripDetails(id), HttpStatus.OK);
  }

  @GetMapping(path = "/trip/summary", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TripSummaryDTO>> getTripSummary(@RequestParam String clientId) {
    return new ResponseEntity<>(tripService.getTripSummary(clientId), HttpStatus.OK);
  }
}