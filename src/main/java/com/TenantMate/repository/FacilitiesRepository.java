package com.TenantMate.repository;

import com.TenantMate.entity.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacilitiesRepository extends JpaRepository<Facilities, Integer> {
    Optional<Facilities> findByFacilityName(String facilityName);
}