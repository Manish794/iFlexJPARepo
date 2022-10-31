package com.manish.jpa.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString

@Entity
@Table(name="lab2_student")
public class Student {

    @Id
    @Column(name="sid")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="sname")
    private String name;

    @ElementCollection
    @CollectionTable(name="lab2_emails", joinColumns = @JoinColumn(name="sid"))
    @Column(name="semail")
    private List<String> emails;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="lab2_phones", joinColumns = @JoinColumn(name="sid"))
    @Column(name="sphone")
    private Set<Long> phones;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="lab2_marks", joinColumns = @JoinColumn(name="sid"))
    @MapKeyColumn(name="topic")
    @Column(name="markObtained")
    private Map<String,Integer> marks;

}
