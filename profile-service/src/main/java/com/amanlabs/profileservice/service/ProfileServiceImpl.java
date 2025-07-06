package com.amanlabs.profileservice.service;

import com.amanlabs.profileservice.dto.ProfileRequestDto;
import com.amanlabs.profileservice.dto.ProfileResponseDto;
import com.amanlabs.profileservice.model.Profile;
import com.amanlabs.profileservice.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileResponseDto createProfile(ProfileRequestDto requestDto) {

        Optional<Profile> existingProfileOpt = profileRepository.findByUserId(requestDto.getUserId());

//        System.out.println("existingProfileOpt: " + existingProfileOpt);
        if (existingProfileOpt.isPresent()) {
            // Update existing profile
            Profile existingProfile = existingProfileOpt.get();

            System.out.println("existingProfile: " + existingProfile.getId());
            System.out.println("existingProfile: " + existingProfile.getUserId());

            existingProfile.setFirstName(requestDto.getFirstName());
            existingProfile.setLastName(requestDto.getLastName());
            existingProfile.setDateOfBirth(requestDto.getDateOfBirth());
            existingProfile.setGender(requestDto.getGender());
            existingProfile.setNativePlace(requestDto.getNativePlace());
            existingProfile.setCurrentLocation(requestDto.getCurrentLocation());
            existingProfile.setJobTitle(requestDto.getJobTitle());
            existingProfile.setIndustry(requestDto.getIndustry());
            existingProfile.setReligion(requestDto.getReligion());
            existingProfile.setMaritalStatus(requestDto.getMaritalStatus());
            existingProfile.setAbout(requestDto.getAbout());

            Profile updatedProfile = profileRepository.save(existingProfile);
            return entityToDto(updatedProfile);

        } else {
            // Create new profile
            Profile newProfile = dtoToEntity(requestDto);
            Profile savedProfile = profileRepository.save(newProfile);
            return entityToDto(savedProfile);
        }
    }

    @Override
    public ProfileResponseDto getProfileByUserId(Long userId) {

        Optional<Profile> profile = profileRepository.findByUserId(userId);
        return profile != null ? entityToDto(profile.get()): null;
    }


    // 🔄 Convert Request DTO → Entity
    private Profile dtoToEntity(ProfileRequestDto dto) {
        return Profile.builder()
                .userId(dto.getUserId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .gender(dto.getGender())
                .nativePlace(dto.getNativePlace())
                .currentLocation(dto.getCurrentLocation())
                .jobTitle(dto.getJobTitle())
                .industry(dto.getIndustry())
                .religion(dto.getReligion())
                .maritalStatus(dto.getMaritalStatus())
                .about(dto.getAbout())
                .build(); // timestamps handled by BaseEntity
    }

    // 🔄 Convert Entity → Response DTO
    private ProfileResponseDto entityToDto(Profile profile) {

        return ProfileResponseDto.builder()
                .userId(profile.getUserId())
                .fullName(profile.getFirstName() + " " + profile.getLastName())
                .dateOfBirth(profile.getDateOfBirth())
                .gender(profile.getGender())
                .nativePlace(profile.getNativePlace())
                .currentLocation(profile.getCurrentLocation())
                .jobTitle(profile.getJobTitle())
                .industry(profile.getIndustry())
                .religion(profile.getReligion())
                .maritalStatus(profile.getMaritalStatus())
                .about(profile.getAbout())
                .createdAt(profile.getCreatedAt())
                .updatedAt(profile.getUpdatedAt())
                .build();
    }
}
