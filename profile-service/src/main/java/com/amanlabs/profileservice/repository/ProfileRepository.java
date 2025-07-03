package com.amanlabs.profileservice.repository;

import com.amanlabs.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    
}
