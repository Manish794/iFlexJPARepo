package com.manish.jpa.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString

@Entity
@Table(name="lab5_student")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student {

    @Id
    @Column(name="sid")
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    @Column(name="sname")
    private String name;

    @Column(name="semail")
    private String email;

    private long phone;

}
