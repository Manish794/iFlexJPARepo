package com.manish.jpa.entity;


import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@ToString

@Entity
@Table(name="lab10_employee")
public class Employee {

    @Id
    @Column(name="eid")
    @GenericGenerator(
            name = "eidGenerator",
            strategy = "com.manish.jpa.id.EmployeeIdGenerator"
    )
    @GeneratedValue( generator = "eidGenerator")
    @Embedded
    private EmployeeId id;

    @Column(name="ename")
    private String name;

    private String email;

    private long phone;

}
