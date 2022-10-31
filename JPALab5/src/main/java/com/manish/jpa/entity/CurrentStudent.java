package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString

@Entity
@Table(name="lab5_cstudent")
public class CurrentStudent extends Student {

    private String timing;
    private String batch;

}
