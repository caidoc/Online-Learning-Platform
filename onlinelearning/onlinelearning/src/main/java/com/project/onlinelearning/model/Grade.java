//package com.project.onlinelearning.model;
//
//import javax.persistence.*;
//
//@Entity
//public class Grade {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long gradeId;
//
//    @ManyToOne
//    @JoinColumn(name = "assessment_id")
//    private Assessment assessment;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private User student;
//
//    private Double score;
//
//    // Getters and Setters
//}
