package com.TenantMate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(name = "unique_facilityName", columnNames = "facilityName")})
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facilityId;
    private String facilityName;
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "facilities")
    private List<Property> property = new ArrayList<>();
}