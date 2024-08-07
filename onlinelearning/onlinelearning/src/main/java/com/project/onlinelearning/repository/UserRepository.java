package com.project.onlinelearning.repository;

import com.project.onlinelearning.model.Student;
import com.project.onlinelearning.model.Teacher;
import com.project.onlinelearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM Teacher u")
    List<Teacher> findAllTeachers();

    @Query("SELECT u FROM Student u")
    List<Student> findAllStudents();

}
