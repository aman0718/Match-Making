package com.amanlabs.profileservice.dto.family;

import lombok.Data;

@Data
public class FamilyRequestDto {

    private String fatherOccupation;
    private String motherOccupation;
    private Long numberOfBrothers;
    private Long numberOfSisters;
    private String community;
    private String aboutFamily;
}
