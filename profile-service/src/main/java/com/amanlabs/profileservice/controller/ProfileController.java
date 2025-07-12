package com.amanlabs.profileservice.controller;


import com.amanlabs.profileservice.dto.profile.ProfileRequestDto;
import com.amanlabs.profileservice.dto.profile.ProfileResponseDto;
import com.amanlabs.profileservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class ProfileController {


    private final ProfileService profileService;


    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody ProfileRequestDto requestDto) {

        ProfileResponseDto responseDto = profileService.createProfile(requestDto);
//        System.out.println("Status: "+responseDto.getStatus());
//        System.out.println("Full Response DTO: "+responseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Long userId){

        ProfileResponseDto profile = profileService.getProfileByUserId(userId);

        if(profile == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfileResponseDto>> getAllProfiles() {
        List<ProfileResponseDto> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }


    @PutMapping("/{userId}/soft-delete")
    public ResponseEntity<?> softDeleteProfile(@PathVariable Long userId){
        profileService.softDeleteProfileByUserId(userId);
        return ResponseEntity.ok("Profile deleted successfully for userId: " + userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteProfileByUserId(@PathVariable Long userId){
        profileService.deleteProfileByUserId(userId);
        return ResponseEntity.ok("Profile deleted successfully for userId: " + userId);
    }

    @PutMapping("/{userId}/restore")
    public ResponseEntity<?> restoreProfile(@PathVariable Long userId){
        profileService.restoreProfileByUserId(userId);
        return ResponseEntity.ok("Profile restored successfully for userId: " + userId);
    }

    @GetMapping("/all-deleted")
    public ResponseEntity<?> getAllProfilesDeleted(){
        List<ProfileResponseDto> allDeletedProfiles = profileService.getAllProfileByIsDeletedTrue();
        return ResponseEntity.ok(allDeletedProfiles);
    }
}
