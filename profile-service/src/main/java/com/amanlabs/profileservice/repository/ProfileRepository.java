package com.amanlabs.profileservice.repository;

import com.amanlabs.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByUserId(Long userId);

    Optional<Profile> findByUserIdAndIsDeletedFalse(Long userId);
    List<Profile> findAllByIsDeletedFalse();


    
}
