package com.project.onlinelearning.service;

import com.project.onlinelearning.model.Student;
import com.project.onlinelearning.model.Teacher;
import com.project.onlinelearning.model.User;
import com.project.onlinelearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<Teacher> getAllTeachers() {
        return userRepository.findAllTeachers();
    }

    public List<Student> getAllStudents() {
        return userRepository.findAllStudents();
    }

    public String getRole(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            if (user.get() instanceof Teacher) {
                return "teacher";
            } else if (user.get() instanceof Student) {
                return "student";
            }
        }
        return "UNKNOWN";
    }
}
