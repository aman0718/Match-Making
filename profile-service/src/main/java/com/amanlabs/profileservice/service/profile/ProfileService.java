package com.amanlabs.profileservice.service.profile;

import com.amanlabs.profileservice.dto.profile.ProfileRequestDto;
import com.amanlabs.profileservice.dto.profile.ProfileResponseDto;
import com.amanlabs.profileservice.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

    ProfileResponseDto createProfile(ProfileRequestDto requestDto);
    void deleteProfileByUserId(Long userId);

    void softDeleteProfileByUserId(Long userId);

    ProfileResponseDto getProfileByUserId(Long userId);


    List<ProfileResponseDto> getAllProfiles();


}
