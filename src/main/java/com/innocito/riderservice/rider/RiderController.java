package com.innocito.riderservice.rider;

import com.innocito.riderservice.rider.dto.RiderDTO;
import com.innocito.riderservice.rider.dto.RiderUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderController {
  @Autowired
  private RiderService riderService;

  @PostMapping(path = "/rider", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
    MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RiderDTO> registerRider(@Valid @RequestBody RiderDTO riderDTO) {
    return new ResponseEntity<>(riderService.registerRider(riderDTO), HttpStatus.CREATED);
  }

  @PutMapping(path = "/rider", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
    MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RiderDTO> updateRider(@Valid @RequestBody RiderUpdateDTO riderUpdateDTO) {
    return new ResponseEntity<>(riderService.updateRider(riderUpdateDTO), HttpStatus.OK);
  }

  @GetMapping(path = "/rider/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RiderDTO> getRider(@PathVariable String id) {
    // TODO: we can also get by email if needed
    return new ResponseEntity<>(riderService.getRider(id), HttpStatus.OK);
  }
}
