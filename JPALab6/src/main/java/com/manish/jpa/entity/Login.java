package com.manish.jpa.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString

@Entity
@Table(name="lab6_login")
public class Login {

    @Id
    @Column(name="loginId")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String role;

    @OneToOne(mappedBy = "userLogin")
    private Student student;
    
}
