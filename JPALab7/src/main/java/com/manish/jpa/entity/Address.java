package com.manish.jpa.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString

@Entity
@Table(name="lab7_address")
public class Address {

    @Id
    @Column(name="aid")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

   private String street;
   private String city;
   private int pin;

   @ManyToOne
   @JoinColumn(name="stid", referencedColumnName = "sid")
   private Student student;

}
