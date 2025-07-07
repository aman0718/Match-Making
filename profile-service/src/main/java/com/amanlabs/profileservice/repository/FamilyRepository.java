package com.amanlabs.profileservice.repository;

import com.amanlabs.profileservice.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {

    Family findByProfileId(Long profileId);
}
