//package com.project.onlinelearning.model;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class Enrollment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long enrollmentId;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private User student;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    private LocalDateTime enrollmentDate = LocalDateTime.now();
//
//    // Getters and Setters
//}
