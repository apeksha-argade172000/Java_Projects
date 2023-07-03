package com.college.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="student_table")
public class StudModel {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studid;

    @Column(name = "student_name")
    private String name;

    @Column(name = "address")
    private String addr;

    @Column(name = "date_of_birth")
    private String dob;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "contact")
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id",referencedColumnName = "institute_id")
    private ClgModel inst;


}

