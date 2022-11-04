package com.manish.jpa.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@ToString

@Entity
@Table(name="lab9_employee")
public class Employee {

    @Id
    @Column(name="eid")
    @GenericGenerator(
            name = "eidGenerator",
            strategy = "com.manish.jpa.id.EmployeeIdGenerator"
    )
    @GeneratedValue( generator = "eidGenerator")
    private String id;

    @Column(name="ename")
    private String name;

    private String email;

    private long phone;

}
