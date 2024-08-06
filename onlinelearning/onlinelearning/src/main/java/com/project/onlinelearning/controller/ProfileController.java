package com.project.onlinelearning.controller;


import com.project.onlinelearning.model.Profile;
import com.project.onlinelearning.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return profileService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Profile>> findByFirstNameOrLastNameOrEmail(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {
        List<Profile> profiles = profileService.findByFirstNameOrLastNameOrEmail(firstname, lastName, email);
        if (profiles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profiles);
    }
    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return profileService.findById(id)
                .map(existingProfile -> {
                    profile.setId(existingProfile.getId());
                    return ResponseEntity.ok(profileService.save(profile));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        if (profileService.findById(id).isPresent()) {
            profileService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
