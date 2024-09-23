package com.TenantMate.utility;

import com.TenantMate.entity.Facilities;
import com.TenantMate.entity.Property;
import com.TenantMate.payload.AddressDTO;
import com.TenantMate.payload.FacilitiesDTO;
import com.TenantMate.payload.PropertyDTO;

public class EntityToDto {
    public static FacilitiesDTO entityTofacilityDto(Facilities f) {
        return new FacilitiesDTO(f.getFacilityId(), f.getFacilityName());
    }

    public static PropertyDTO entityToPropertyDto(Property p) {
        PropertyDTO pm = new PropertyDTO();
        pm.setPropertyId(p.getPropertyId());
        pm.setPropertyName(p.getPropertyName());
        pm.setCareTakerName(p.getCareTakerName());
        pm.setCareTakerPhoneNo(p.getCareTakerPhoneNo());
        pm.setNumberOfFloors(p.getNumberOfFloors());
        pm.setNumberOfRooms(p.getNumberOfRooms());
        pm.setOwnerName(p.getOwnerName());
        pm.setOwnerPhoneNo(p.getOwnerPhoneNo());
        pm.setRoomsOccupied(p.getRoomsOccupied());
        AddressDTO am = new AddressDTO();
        am.setAddressId(p.getAddress().getAddressId());
        am.setAddressLine1(p.getAddress().getAddressLine1());
        am.setAddressLine2(p.getAddress().getAddressLine2());
        am.setCity(p.getAddress().getCity());
        am.setState(p.getAddress().getState());
        am.setZipCode(p.getAddress().getZipCode());
        am.setLandmark(p.getAddress().getLandmark());
        pm.setAddress(am);
        return pm;
    }
}