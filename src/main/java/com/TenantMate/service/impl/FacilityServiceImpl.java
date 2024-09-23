package com.TenantMate.service.impl;

import com.TenantMate.entity.Facilities;
import com.TenantMate.payload.FacilitiesDTO;
import com.TenantMate.repository.FacilitiesRepository;
import com.TenantMate.service.FacilityService;
import com.TenantMate.utility.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    FacilitiesRepository facilityrepo;

    @Override
    public List<FacilitiesDTO> getAllFacilitites() {
        List<Facilities> all = facilityrepo.findAll();
        List<FacilitiesDTO> facilitiesDTOList = new ArrayList<>();
        for (Facilities f : all) {
            FacilitiesDTO facilitiesDTO = EntityToDto.entityTofacilityDto(f);
            facilitiesDTOList.add(facilitiesDTO);
        }
        return facilitiesDTOList;
    }

    @Override
    public String saveFacility(String facilityName) {
        Facilities facility = new Facilities();
        facility.setFacilityName(facilityName);
        FacilitiesDTO facilitiesDTO = EntityToDto.entityTofacilityDto(facilityrepo.save(facility));
        return "success, id: " + facilitiesDTO.getFacilityId();
    }
}