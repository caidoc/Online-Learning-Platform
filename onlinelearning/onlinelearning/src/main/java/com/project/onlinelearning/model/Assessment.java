//package com.project.onlinelearning.model;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//public class Assessment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long assessmentId;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    private String title;
//
//    @Lob
//    private String description;
//
//    private String type;
//
//    private LocalDate date;
//
//    @OneToMany(mappedBy = "assessment")
//    private List<Grade> grades;
//
//    // Getters and Setters
//}
