package com.TenantMate.service;

import com.TenantMate.entity.Property;
import com.TenantMate.payload.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public String addProperty(Property property);

    List<PropertyDTO> getAllProperty();

    PropertyDTO getPropertyById(Integer id);

    String updateProperty(Property property);
}