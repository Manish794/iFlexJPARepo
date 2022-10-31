package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@ToString

@Entity
@Table(name="lab3_onlinestudent")
@PrimaryKeyJoinColumn(name="sid")
public class OnlineStudent extends  CurrentStudent {

    private String link;
    private String passCode;

}
