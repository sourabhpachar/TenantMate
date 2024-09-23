package com.TenantMate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Room {

    enum Type {
       Cooler,
        AC
    }
    enum Furnishing {
        Fully_Furnished,
        Semi_Furnished,
        Unfurnished
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean balcony;
    private Type roomType;
    private Furnishing furnishing;


}
