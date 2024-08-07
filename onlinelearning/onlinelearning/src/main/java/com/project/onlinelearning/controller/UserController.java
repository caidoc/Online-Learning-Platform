package com.project.onlinelearning.controller;


import com.project.onlinelearning.model.Student;
import com.project.onlinelearning.model.Teacher;
import com.project.onlinelearning.model.User;
import com.project.onlinelearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return userService.getAllTeachers();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return userService.getAllStudents();
    }

    @GetMapping("/role")
    public  ResponseEntity<String> getRole(@PathVariable Long id) {
        return  ResponseEntity.ok(userService.getRole(id));
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.save(user);
//    }
    @PostMapping
    public  ResponseEntity<User> createUser(@RequestBody User user) {
        if (user instanceof Teacher) {
            return ResponseEntity.ok(userService.save(user));
        } else if (user instanceof Student) {
            return ResponseEntity.ok(userService.save(user));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.findById(id)
//                .map(existingUser -> {
//                    user.setId(existingUser.getId());
//                    return ResponseEntity.ok(userService.save(user));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> existingUser = userService.findById(id);
        if  (!existingUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User existing = existingUser.get();
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());

        if (existing instanceof Teacher && user instanceof Teacher) {
            ((Teacher) existing).setDepartment(((Teacher) user).getDepartment());
        } else if (existing instanceof Student && user instanceof Student) {
            ((Student) existing).setSection(((Student) user).getSection());
        } else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userService.save(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
