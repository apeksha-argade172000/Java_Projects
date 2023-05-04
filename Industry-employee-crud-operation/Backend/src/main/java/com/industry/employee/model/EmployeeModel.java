package com.industry.employee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer empid;

    @Column(name = "emp_name")
    private String empname;

    @Column(name = "emp_contact")
    private String contact;

    @Column(name = "emp_addr")
    private String addr;

    @Column(name = "emp_dob")
    private String dob;

    @JoinColumn(name = "industry_id",referencedColumnName = "industry_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private IndustryModel ind;

    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentModel dept;



}
