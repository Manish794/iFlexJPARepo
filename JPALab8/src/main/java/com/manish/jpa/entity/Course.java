package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString

@Entity
@Table(name="lab8_course")
public class Course {
    @Id
    @Column(name="cid")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="cname")
    private String name;

    private String duration;

    private double fee;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

}
