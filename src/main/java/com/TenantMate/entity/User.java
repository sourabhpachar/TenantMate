package com.TenantMate.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Table(name="users" ,uniqueConstraints = {@UniqueConstraint(name = "email_unique", columnNames = "email")})
@Entity
@Data
//@Table(name="product",schema = "shopNexus",uniqueConstraints = {@UniqueConstraint(name = "sku_unique",columnNames = "stock_keeping_unit")})

public class User {



   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
    private int id;
    private String name;
    private String address;
    private int phoneNo;
    private String idProof;
    private int emergencyContactNumber;
    private LocalDate leavingDate;
    private String accessCardDetails;

    private int roomNo;
    private boolean isActive;
    private String propertyName;
    private int roomRent;
    @CreationTimestamp
    private LocalDate joiningDate;
    private String email;
//    private List<Role> roles;



}
