package com.TenantMate.service.impl;

import com.TenantMate.entity.Facilities;
import com.TenantMate.payload.FacilitiesDTO;
import com.TenantMate.repository.FacilitiesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FacilityServiceImplTest {

    @Mock
    FacilitiesRepository facilityrepo;

    @Test
    void getAllFacilityTest(){
        List<Facilities> all = facilityrepo.findAll();
        List<FacilitiesDTO> facilitiesDTOList = new ArrayList<>();
        for (Facilities f : all) {
            FacilitiesDTO facilitiesDTO = com.TenantMate.utility.EntityToDto.entityTofacilityDto(f);
            facilitiesDTOList.add(facilitiesDTO);
        }
        //return facilitiesDTOList;;
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}