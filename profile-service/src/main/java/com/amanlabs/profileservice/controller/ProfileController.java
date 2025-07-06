package com.amanlabs.profileservice.controller;


import com.amanlabs.profileservice.dto.ProfileRequestDto;
import com.amanlabs.profileservice.dto.ProfileResponseDto;
import com.amanlabs.profileservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody ProfileRequestDto requestDto) {

        ProfileResponseDto responseDto = profileService.createProfile(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
