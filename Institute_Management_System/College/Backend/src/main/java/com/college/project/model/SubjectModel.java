package com.college.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "subject_table")
public class SubjectModel {
    @Id
    @Column(name = "sub_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subid;

    @Column(name = "sub_name")
    private String subname;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id",referencedColumnName = "institute_id")
    private ClgModel inst;

}
