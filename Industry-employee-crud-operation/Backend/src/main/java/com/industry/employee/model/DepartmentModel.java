package com.industry.employee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "department")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private Integer deptid;

    @Column(name = "dept_name")
    private String name;

    @JoinColumn(name = "industry_id",referencedColumnName = "industry_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private IndustryModel ind;
}
