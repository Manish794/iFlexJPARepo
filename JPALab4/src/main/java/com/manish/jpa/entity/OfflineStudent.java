package com.manish.jpa.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@ToString

@Entity
@DiscriminatorValue("OFFLINE")
public class OfflineStudent extends  CurrentStudent {

    private String roomNumber;
    private String seatNo;

}
