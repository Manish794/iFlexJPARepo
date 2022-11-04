package com.manish.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeId implements Serializable {

    private String branch;
    private int empId;

}
