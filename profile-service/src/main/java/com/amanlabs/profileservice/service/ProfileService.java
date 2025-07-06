package com.amanlabs.profileservice.service;

import com.amanlabs.profileservice.dto.ProfileRequestDto;
import com.amanlabs.profileservice.dto.ProfileResponseDto;
import com.amanlabs.profileservice.model.BaseEntity;

public interface ProfileService {

    ProfileResponseDto createProfile(ProfileRequestDto requestDto);

    ProfileResponseDto getProfileByUserId(Long userId);


}
