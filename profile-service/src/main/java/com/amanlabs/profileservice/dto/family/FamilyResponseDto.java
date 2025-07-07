package com.amanlabs.profileservice.dto.family;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FamilyResponseDto {

    private Long id;
    private String fatherOccupation;
    private String motherOccupation;
    private Long numberOfBrothers;
    private Long numberOfSisters;
    private String community;
    private String aboutFamily;
}
