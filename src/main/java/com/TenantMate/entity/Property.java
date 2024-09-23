package com.TenantMate.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(name = "unique_propertyName", columnNames = "propertyName")})
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;
    private String propertyName;
    private String ownerName;
    private long ownerPhoneNo;
    private int numberOfFloors;

    private int numberOfRooms;


    private int roomsOccupied;
    private String careTakerName;
    private long careTakerPhoneNo;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "propertyToFacilityMap", joinColumns = @JoinColumn(name = "propertyId", referencedColumnName = "propertyId"), inverseJoinColumns = @JoinColumn(name = "facilityId", referencedColumnName = "facilityId"))
    private Set<Facilities> facilities = new HashSet<>();
}