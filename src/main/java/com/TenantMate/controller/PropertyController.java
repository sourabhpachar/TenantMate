package com.TenantMate.controller;

import com.TenantMate.entity.Property;
import com.TenantMate.exception.BusinessException;
import com.TenantMate.payload.PropertyDTO;
import com.TenantMate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("properties")
public class PropertyController {
    @Autowired
    PropertyService service;

    @PostMapping
    public ResponseEntity<String> addProperty(@RequestBody Property property) {
        return new ResponseEntity<>(service.addProperty(property), HttpStatus.OK);
    }

    @GetMapping
    public List<PropertyDTO> getAllProperties() {
        return service.getAllProperty();
    }

    @GetMapping("{id}")
    public PropertyDTO getPropertyById(@PathVariable Integer id) {
        PropertyDTO propertyById = service.getPropertyById(id);
        if (propertyById != null) return propertyById;
        else throw new BusinessException("Business exception thrown");
    }

    @PutMapping()
    public String updateProperty(@RequestBody Property property) {
        return service.updateProperty(property);
    }
}