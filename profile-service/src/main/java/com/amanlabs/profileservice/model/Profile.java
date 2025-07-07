package com.amanlabs.profileservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_profiles")
public class Profile extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String maritalStatus;
    private String about;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Family familyDetails;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}
