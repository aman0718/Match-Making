package com.amanlabs.matchpreference.entities;

import com.amanlabs.matchpreference.enums.Gender;
import com.amanlabs.matchpreference.enums.ProfileMode;
import com.amanlabs.matchpreference.enums.Religion;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "match_preference")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchPreference {

    private Long id;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Gender preferredGender;
    private Integer minAge;
    private Integer maxAge;

    @Enumerated(EnumType.STRING)
    private Religion preferredReligion;


    @Enumerated(EnumType.STRING)
    private ProfileMode preference;
}
