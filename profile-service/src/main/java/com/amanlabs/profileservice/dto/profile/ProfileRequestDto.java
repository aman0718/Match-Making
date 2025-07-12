package com.amanlabs.profileservice.dto.profile;

import com.amanlabs.profileservice.dto.family.FamilyRequestDto;
import com.amanlabs.profileservice.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ProfileRequestDto {

    private Long userId;
    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
    private ProfileStatus status;
    private FamilyRequestDto familyDetails;


}
