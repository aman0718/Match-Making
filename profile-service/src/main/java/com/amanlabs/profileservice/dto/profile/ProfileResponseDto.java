package com.amanlabs.profileservice.dto.profile;

import com.amanlabs.profileservice.dto.family.FamilyResponseDto;
import com.amanlabs.profileservice.enums.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
public class ProfileResponseDto {

    private Long userId;
    private String fullName;
    private LocalDate birthDetails;
    private Gender gender;
    private String nativePlace;
    private String currentLocation;
    private String jobTitle;
    private String industry;
    private Religion religion;
    private MaritalStatus maritalStatus;
    private String about;
    private ProfileMode preference;
    private Boolean isDeleted;
    private ProfileStatus status;
    private FamilyResponseDto familyDetails;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
