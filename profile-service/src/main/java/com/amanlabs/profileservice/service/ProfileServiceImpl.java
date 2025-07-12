package com.amanlabs.profileservice.service;

import com.amanlabs.profileservice.dto.family.FamilyRequestDto;
import com.amanlabs.profileservice.dto.family.FamilyResponseDto;
import com.amanlabs.profileservice.dto.profile.ProfileRequestDto;
import com.amanlabs.profileservice.dto.profile.ProfileResponseDto;
import com.amanlabs.profileservice.enums.ProfileStatus;
import com.amanlabs.profileservice.entities.Family;
import com.amanlabs.profileservice.entities.Profile;
import com.amanlabs.profileservice.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public ProfileResponseDto createProfile(ProfileRequestDto requestDto) {

        Optional<Profile> optionalProfile = profileRepository.findByUserId(requestDto.getUserId());

        if (optionalProfile.isPresent()) {

            // Update existing profile
            Profile existingProfile = optionalProfile.get();

            existingProfile.setFirstName(requestDto.getFirstName());
            existingProfile.setLastName(requestDto.getLastName());
            existingProfile.setBirthDetails(requestDto.getBirthDetails());
            existingProfile.setGender(requestDto.getGender());
            existingProfile.setNativePlace(requestDto.getNativePlace());
            existingProfile.setCurrentLocation(requestDto.getCurrentLocation());
            existingProfile.setJobTitle(requestDto.getJobTitle());
            existingProfile.setIndustry(requestDto.getIndustry());
            existingProfile.setReligion(requestDto.getReligion());
            existingProfile.setMaritalStatus(requestDto.getMaritalStatus());
            existingProfile.setAbout(requestDto.getAbout());
            existingProfile.setPreference(requestDto.getPreference());
            existingProfile.setIsDeleted(false);

            if(requestDto.getStatus() != null){
                existingProfile.setStatus(requestDto.getStatus());
            }
            else existingProfile.setStatus(ProfileStatus.UNDER_SCREENING);


            // Update family details
            if (requestDto.getFamilyDetails() != null) {
                Family existingFamily = existingProfile.getFamilyDetails();

                // If family details are not present, create a new family
                if(existingFamily == null){
                    Family family = familyDtoToEntity(requestDto.getFamilyDetails(), existingProfile);
                    existingProfile.setFamilyDetails(family);
                }
                // If family details are present, update them
                else{
                    FamilyRequestDto fdDto = requestDto.getFamilyDetails();
                    existingFamily.setFatherOccupation(fdDto.getFatherOccupation());
                    existingFamily.setMotherOccupation(fdDto.getMotherOccupation());
                    existingFamily.setNumberOfBrothers(fdDto.getNumberOfBrothers());
                    existingFamily.setNumberOfSisters(fdDto.getNumberOfSisters());
                    existingFamily.setCommunity(fdDto.getCommunity());
                    existingFamily.setAboutFamily(fdDto.getAboutFamily());
                }
            }

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
    @Transactional
    public ProfileResponseDto getProfileByUserId(Long userId) {
        return profileRepository.findByUserIdAndIsDeletedFalse(userId)
                .map(this::entityToDto)
                .orElseThrow(()-> new RuntimeException("Profile not found"));
    }

    @Override
    @Transactional
    public List<ProfileResponseDto> getAllProfiles() {
        return profileRepository.findAllByIsDeletedFalse()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProfileByUserId(Long userId) {

        Optional<Profile> optionalProfile = profileRepository.findByUserId(userId);

        if(optionalProfile.isPresent()){
            Profile deleteProfile = optionalProfile.get();
            profileRepository.delete(deleteProfile);
        }else{
            throw new RuntimeException("Profile not found for userId: " + userId);
        }
    }


    @Override
    @Transactional
    public void softDeleteProfileByUserId(Long userId) {

        Optional<Profile> optionalProfile = profileRepository.findByUserId(userId);

        if(optionalProfile.isPresent()){
            Profile deleteProfile = optionalProfile.get();
            deleteProfile.setIsDeleted(true);
            profileRepository.save(deleteProfile);
        }
        else {
            throw new RuntimeException("Profile not found for userId: " + userId);
        }
    }


    @Override
    @Transactional
    public void restoreProfileByUserId(Long userId) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(()-> new RuntimeException("No profile found"));

        if(!Boolean.TRUE.equals(profile.getIsDeleted())){
            throw new RuntimeException("Profile cannot be restored for userId: " + userId);
        }
        profile.setIsDeleted(false);
        profileRepository.save(profile);
    }

    @Override
    public List<ProfileResponseDto> getAllProfileByIsDeletedTrue() {

        return profileRepository.findAllByIsDeletedTrue()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void approveProfile(Long userId) {

//        implement admin approval
    }

    @Override
    public void rejectProfile(Long userId, String reason) {

    }

    @Override
    public List<ProfileResponseDto> getAllPendingProfiles() {
        return null;
    }

    // 🔄 Convert Request DTO → Entity
    private Profile dtoToEntity(ProfileRequestDto dto) {
        Profile profile = Profile.builder()
                .userId(dto.getUserId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDetails(dto.getBirthDetails())
                .gender(dto.getGender())
                .nativePlace(dto.getNativePlace())
                .currentLocation(dto.getCurrentLocation())
                .jobTitle(dto.getJobTitle())
                .industry(dto.getIndustry())
                .religion(dto.getReligion())
                .maritalStatus(dto.getMaritalStatus())
                .about(dto.getAbout())
                .preference(dto.getPreference())
                .isDeleted(false)
                .status(dto.getStatus() != null ? dto.getStatus() : ProfileStatus.UNDER_SCREENING)
                .build(); // timestamps handled by BaseEntity

        if(dto.getFamilyDetails() != null){
            Family family = familyDtoToEntity(dto.getFamilyDetails(), profile);
            profile.setFamilyDetails(family);
        }
        return profile;
    }

    // 🔄 Convert Entity → Response DTO
    private ProfileResponseDto entityToDto(Profile profile) {

        ProfileResponseDto.ProfileResponseDtoBuilder builder = ProfileResponseDto.builder()
                .userId(profile.getUserId())
                .fullName(profile.getFirstName() + " " + profile.getLastName())
                .birthDetails(profile.getBirthDetails())
                .gender(profile.getGender())
                .nativePlace(profile.getNativePlace())
                .currentLocation(profile.getCurrentLocation())
                .jobTitle(profile.getJobTitle())
                .industry(profile.getIndustry())
                .religion(profile.getReligion())
                .maritalStatus(profile.getMaritalStatus())
                .about(profile.getAbout())
                .preference(profile.getPreference())
                .status(profile.getStatus())
                .isDeleted(profile.getIsDeleted())
                .createdAt(profile.getCreatedAt())
                .updatedAt(profile.getUpdatedAt());

        if(profile.getFamilyDetails() != null){
            Family family = profile.getFamilyDetails();
            builder.familyDetails(FamilyResponseDto.builder()
                    .id(family.getId())
                    .fatherOccupation(family.getFatherOccupation())
                    .motherOccupation(family.getMotherOccupation())
                    .numberOfBrothers(family.getNumberOfBrothers())
                    .numberOfSisters(family.getNumberOfSisters())
                    .community(family.getCommunity())
                    .aboutFamily(family.getAboutFamily())
                    .build());
        }
        return builder.build();
    }

    private Family familyDtoToEntity(FamilyRequestDto fdDto, Profile profile) {
        return Family.builder()
                .fatherOccupation(fdDto.getFatherOccupation())
                .motherOccupation(fdDto.getMotherOccupation())
                .numberOfBrothers(fdDto.getNumberOfBrothers())
                .numberOfSisters(fdDto.getNumberOfSisters())
                .community(fdDto.getCommunity())
                .aboutFamily(fdDto.getAboutFamily())
                .profile(profile)
                .build();
    }
}
