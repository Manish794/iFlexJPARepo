package com.manish.jpa.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString

@Entity
@Table(name="lab4_student")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="sType", length = 8)
@DiscriminatorValue("STU")
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

}
