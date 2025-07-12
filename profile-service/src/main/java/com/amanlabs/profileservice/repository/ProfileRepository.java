package com.amanlabs.profileservice.repository;

import com.amanlabs.profileservice.enums.Gender;
import com.amanlabs.profileservice.enums.ProfileMode;
import com.amanlabs.profileservice.enums.ProfileStatus;
import com.amanlabs.profileservice.enums.Religion;
import com.amanlabs.profileservice.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByUserId(Long userId);

    Optional<Profile> findByUserIdAndIsDeletedFalse(Long userId);
    List<Profile> findAllByIsDeletedFalse();

    List<Profile> findAllByIsDeletedTrue();

    List<Profile> findAllByStatus(ProfileStatus status);

    List<Profile> findAllByPreference(ProfileMode preference);

    List<Profile> findAllByReligion(Religion religion);

    List<Profile> findAllByGenderAndIsDeletedFalse(Gender gender);
    
}
