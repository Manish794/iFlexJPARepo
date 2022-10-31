package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@ToString

@Entity
@Table(name="lab3_offlinestudent")
@PrimaryKeyJoinColumn(name="sid")
public class OfflineStudent extends  CurrentStudent {

    private String roomNumber;
    private String seatNo;

}
