package com.TenantMate.repository;

import com.TenantMate.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertiesRepository extends JpaRepository<Property, Integer> {
    Optional<Property> findByPropertyName(String name);
}