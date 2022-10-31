package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString

@Entity
@Table(name="lab5_offlinestudent")
public class OfflineStudent extends  CurrentStudent {

    private String roomNumber;
    private String seatNo;

}
