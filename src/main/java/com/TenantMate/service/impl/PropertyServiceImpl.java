package com.TenantMate.service.impl;

import com.TenantMate.entity.Facilities;
import com.TenantMate.entity.Property;
import com.TenantMate.entity.Room;
import com.TenantMate.payload.FacilitiesDTO;
import com.TenantMate.payload.PropertyDTO;
import com.TenantMate.repository.FacilitiesRepository;
import com.TenantMate.repository.PropertiesRepository;
import com.TenantMate.service.PropertyService;
import com.TenantMate.service.RoomService;
import com.TenantMate.utility.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertiesRepository propertyRepo;
    @Autowired
    FacilitiesRepository facilityRepo;

    RoomService roomService;

    public String addProperty(Property property) {
        Set<Facilities> existingFacilities = new HashSet<>();
        for (Facilities facility : property.getFacilities()) {
            Facilities existingFacility = facilityRepo.findByFacilityName(facility.getFacilityName()).orElse(facility);
            existingFacilities.add(existingFacility);
        }
        property.setFacilities(existingFacilities);
        Property save = propertyRepo.save(property);
        for(int i=0;i<save.getNumberOfRooms();i++){
            Room room=new Room();
            System.out.println(roomService.CreateRoom(room));
        }
        return "Success, id: " + save.getPropertyId();
    }

    @Override
    public List<PropertyDTO> getAllProperty() {
        List<Property> all = propertyRepo.findAll();
        List<PropertyDTO> response = new ArrayList<>();
        for (Property p : all) {
            PropertyDTO pm = EntityToDto.entityToPropertyDto(p);
            Set<FacilitiesDTO> fmm = new HashSet<>();
            for (Facilities f : p.getFacilities()) {
                FacilitiesDTO facilitiesDTO = EntityToDto.entityTofacilityDto(f);
                fmm.add(facilitiesDTO);
            }
            pm.setFacilities(fmm);
            response.add(pm);
        }
        return response;
    }

    @Override
    public PropertyDTO getPropertyById(Integer id) {
        Property property = propertyRepo.findById(id).orElse(null);
        return EntityToDto.entityToPropertyDto(property);
    }

    @Override
    public String updateProperty(Property property) {
        //        Optional<Property> p = propertyRepo.findByPropertyName(property.getPropertyName());
        //        p.ifPresent(value -> property.setPropertyId(value.getPropertyId()));
        //        Property save = propertyRepo.save(property);
        //        return "Success, id: "+save.getPropertyId();
                return "success";
               }

    }