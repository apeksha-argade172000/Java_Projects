package com.college.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "stud_sub_table")
public class StudSubjectModel {
    @Id
    @Column(name = "stud_sub_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stud_sub_id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",referencedColumnName = "student_id")
    private StudModel studModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_id",referencedColumnName = "sub_id")
    private SubjectModel subjectModel;


}
