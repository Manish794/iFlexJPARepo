package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString

@Entity
@DiscriminatorValue("OLD")
public class OldStudent extends Student{

    private String joiningYear;
    private Date dateOfCompletion;

}
