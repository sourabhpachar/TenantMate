package com.TenantMate.payload;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PropertyDTO {
    private Integer propertyId;
    private String propertyName;
    private String ownerName;
    private long ownerPhoneNo;
    private int numberOfFloors;
    private int numberOfRooms;
    private int roomsOccupied;
    private String careTakerName;
    private long careTakerPhoneNo;
    private AddressDTO address;
    private Set<FacilitiesDTO> facilities = new HashSet<>();
}