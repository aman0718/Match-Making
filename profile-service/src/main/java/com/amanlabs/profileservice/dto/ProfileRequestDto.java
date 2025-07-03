package com.amanlabs.profileservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProfileRequestDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String nativePlace;
    private String currentLocation;
    private String jobTitle;
    private String industry;
    private String religion;
    private String community;
    private String maritalStatus;
    private String about;
}
