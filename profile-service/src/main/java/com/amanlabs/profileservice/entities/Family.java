package com.amanlabs.profileservice.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_family_details")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fatherOccupation;
    private String motherOccupation;
    private Long numberOfBrothers;
    private Long numberOfSisters;
    private String community;
    private String aboutFamily;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
