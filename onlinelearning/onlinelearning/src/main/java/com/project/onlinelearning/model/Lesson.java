//package com.project.onlinelearning.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Lesson {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long lessonId;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    private String title;
//
//    @Lob
//    private String content;
//
//    private Integer lessonOrder;
//
//    @OneToMany(mappedBy = "lesson")
//    private List<Comment> comments;
//
//    // Getters and Setters
//}
