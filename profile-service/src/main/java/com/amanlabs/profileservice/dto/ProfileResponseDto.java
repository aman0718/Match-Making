package com.amanlabs.profileservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ProfileResponseDto {

    private Long userId;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String nativePlace;
    private String currentLocation;
    private String jobTitle;
    private String industry;
    private String religion;
    private String maritalStatus;
    private String about;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
