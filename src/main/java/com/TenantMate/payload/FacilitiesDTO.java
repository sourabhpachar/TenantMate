package com.TenantMate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class FacilitiesDTO {
    private Integer facilityId;
    private String facilityName;
}