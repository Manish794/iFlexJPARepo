package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString

@Entity
@Table(name="lab5_onlinestudent")
public class OnlineStudent extends  CurrentStudent {

    private String link;
    private String passCode;

}
