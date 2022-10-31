package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString

@Entity
@Table(name="lab3_oldstudent")
@PrimaryKeyJoinColumn(name="sid")
public class OldStudent extends Student{

    private String joiningYear;
    private Date dateOfCompletion;

}
