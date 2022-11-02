package com.manish.jpa.entity;


import lombok.*;

import javax.persistence.*;

@Data
@ToString

@Entity
@Table(name="lab6_student")
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="loginId")
    private Login userLogin;

}
