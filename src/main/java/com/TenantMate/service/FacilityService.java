package com.TenantMate.service;

import com.TenantMate.payload.FacilitiesDTO;

import java.util.List;

public interface FacilityService {
    public List<FacilitiesDTO> getAllFacilitites();

    public String saveFacility(String facilityName);
}