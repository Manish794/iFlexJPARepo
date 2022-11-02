package com.manish.jpa.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString

@Entity
@Table(name="lab8_student")
public class Student {

    @Id
    @Column(name="sid")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="sname")
    private String name;

    @Column(name="semail")
    private String email;

    private long phone;

    @ManyToMany
    @JoinTable(name="lab8_stud_course",
            joinColumns = @JoinColumn(name="stid", referencedColumnName = "sid"),
            inverseJoinColumns = @JoinColumn(name="courseId", referencedColumnName = "cid")
    )
    private List<Course> courses;

}
