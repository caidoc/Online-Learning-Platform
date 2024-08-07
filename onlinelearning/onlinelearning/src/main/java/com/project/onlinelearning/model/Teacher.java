package com.project.onlinelearning.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("teacher")
public class Teacher extends User {
    private String department;
}
