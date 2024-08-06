package com.project.onlinelearning.service;

import com.project.onlinelearning.model.Profile;
import com.project.onlinelearning.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }


    public List<Profile> findByFirstNameOrLastNameOrEmail(String firstname, String lastName, String email) {
        return profileRepository.findByFirstNameOrLastNameOrEmail(firstname, lastName, email);
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}
