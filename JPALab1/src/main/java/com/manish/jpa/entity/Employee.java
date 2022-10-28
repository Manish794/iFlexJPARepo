package com.manish.jpa.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="lab1_employee")
public class Employee {

    @Id
    @Column(name="eid")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ename")
    private String name;

    private String email;

    private long phone;

    @Temporal(TemporalType.DATE)
    @Column(name="joininig_date")
    private Date doj;

}
