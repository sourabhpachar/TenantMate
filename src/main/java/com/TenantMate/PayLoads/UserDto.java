package com.TenantMate.PayLoads;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDto {

    private int id;
    @Size(min=10,message = "enter minimum 10 characters")
    private String name;

    @Size(min=10,message = "enter minimum 10 characters")
    private String address;
    private int phoneNo;
    private String idProof;
    private int emergencyContactNumber;
    @Future
    private LocalDate leavingDate;
    private String accessCardDetails;
    private int roomNo;
    private boolean isActive;
    private String propertyName;
    private int roomRent;
    private LocalDate joiningDate;
    @Email
    private String email;

    public UserDto(String name, String address, int phoneNo, String idProof, int emergencyContactNumber, LocalDate leavingDate, String accessCardDetails, int roomNo, boolean isActive, String propertyName, int roomRent, String email) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.idProof = idProof;
        this.emergencyContactNumber = emergencyContactNumber;
        this.leavingDate = leavingDate;
        this.accessCardDetails = accessCardDetails;
        this.roomNo = roomNo;
        this.isActive = isActive;
        this.propertyName = propertyName;
        this.roomRent = roomRent;
        this.email = email;
    }

    public UserDto(String address, int phoneNo, int emergencyContactNumber) {
        this.address = address;
        this.phoneNo = phoneNo;
        this.emergencyContactNumber = emergencyContactNumber;
    }
}
