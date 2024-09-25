package com.TenantMate.controller;

import com.TenantMate.entity.Facilities;
import com.TenantMate.payload.FacilitiesDTO;
import com.TenantMate.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("facilities")
public class FacilityController {
    @Autowired
    FacilityService service;

    @GetMapping
    public ResponseEntity<List<FacilitiesDTO>> getAllFacilities() {
        return new ResponseEntity<>(service.getAllFacilitites(), HttpStatus.OK);
    }

    @PostMapping({"addFacility/{facilityName}"})
    public ResponseEntity<String> saveFacility(@PathVariable String facilityName) {
        return new ResponseEntity<>(service.saveFacility(facilityName), HttpStatus.OK);
    }
}