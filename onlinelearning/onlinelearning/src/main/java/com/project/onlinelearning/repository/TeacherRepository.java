package com.project.onlinelearning.repository;

import com.project.onlinelearning.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
