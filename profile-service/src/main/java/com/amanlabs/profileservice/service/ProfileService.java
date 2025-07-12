package com.amanlabs.profileservice.service;

import com.amanlabs.profileservice.dto.profile.ProfileRequestDto;
import com.amanlabs.profileservice.dto.profile.ProfileResponseDto;

import java.util.List;

public interface ProfileService {

    ProfileResponseDto createProfile(ProfileRequestDto requestDto);

    ProfileResponseDto getProfileByUserId(Long userId);

    List<ProfileResponseDto> getAllProfiles();

    void deleteProfileByUserId(Long userId);

    void softDeleteProfileByUserId(Long userId);

    void restoreProfileByUserId(Long userId);

    List<ProfileResponseDto> getAllProfileByIsDeletedTrue();

    void approveProfile(Long userId);

    void rejectProfile(Long userId, String reason);

    // This is for Admin
    List<ProfileResponseDto> getAllPendingProfiles();


}
