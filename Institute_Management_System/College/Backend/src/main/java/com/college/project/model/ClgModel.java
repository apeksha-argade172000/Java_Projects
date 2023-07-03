package com.college.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "college_table")
public class ClgModel {
    @Id
    @Column(name = "institute_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clgId;

    @Column(name = "institute_name")
    private String name;

    @Column(name = "address")
    private String addr;

    @Column(name = "contact")
    private  Integer contact;


}
