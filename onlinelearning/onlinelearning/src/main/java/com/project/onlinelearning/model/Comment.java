//package com.project.onlinelearning.model;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long commentId;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "lesson_id")
//    private Lesson lesson;
//
//    @Lob
//    private String content;
//
//    private LocalDateTime timestamp = LocalDateTime.now();
//
//    // Getters and Setters
//}
