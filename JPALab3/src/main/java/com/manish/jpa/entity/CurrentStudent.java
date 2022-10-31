package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@ToString

@Entity
@Table(name="lab3_cstudent")
@PrimaryKeyJoinColumn(name="sid")
public class CurrentStudent extends Student {

    private String timing;
    private String batch;

}
