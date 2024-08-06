package com.project.onlinelearning.repository;

import com.project.onlinelearning.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("SELECT p FROM Profile p WHERE " +
            "(:firstname IS NULL OR p.firstName = :firstname) OR " +
            "(:lastName IS NULL OR p.lastName = :lastName) OR " +
            "(:email IS NULL OR p.email = :email)")
    List<Profile> findByFirstNameOrLastNameOrEmail(@Param("firstname") String firstname,
                                                   @Param("lastName") String lastName,
                                                   @Param("email") String email);
}
