package com.TenantMate.entity;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property")
    private Property property;


}
