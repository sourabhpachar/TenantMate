package com.TenantMate.payload;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer addressId;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String city;
    private String state;
    private String zipCode;
}